package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ClassComptable;
import ma.sir.easystock.bean.history.ClassComptableHistory;
import ma.sir.easystock.dao.criteria.core.ClassComptableCriteria;
import ma.sir.easystock.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ClassComptableDao;
import ma.sir.easystock.dao.facade.history.ClassComptableHistoryDao;
import ma.sir.easystock.dao.specification.core.ClassComptableSpecification;
import ma.sir.easystock.service.facade.admin.ClassComptableAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.SousClassComptable;

import ma.sir.easystock.service.facade.admin.SousClassComptableAdminService ;


import java.util.List;
@Service
public class ClassComptableAdminServiceImpl extends AbstractServiceImpl<ClassComptable,ClassComptableHistory, ClassComptableCriteria, ClassComptableHistoryCriteria, ClassComptableDao,
ClassComptableHistoryDao> implements ClassComptableAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public ClassComptable create(ClassComptable t) {
        super.create(t);
        if (t.getSousClassComptables() != null) {
                t.getSousClassComptables().forEach(element-> {
                    element.setClassComptable(t);
                    sousClassComptableService.create(element);
            });
        }
        return t;
    }

    public ClassComptable findWithAssociatedLists(Long id){
        ClassComptable result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSousClassComptables(sousClassComptableService.findByClassComptableId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        sousClassComptableService.deleteByClassComptableId(id);
    }


    public void updateWithAssociatedLists(ClassComptable classComptable){
    if(classComptable !=null && classComptable.getId() != null){
            List<List<SousClassComptable>> resultSousClassComptables= sousClassComptableService.getToBeSavedAndToBeDeleted(sousClassComptableService.findByClassComptableId(classComptable.getId()),classComptable.getSousClassComptables());
            sousClassComptableService.delete(resultSousClassComptables.get(1));
            ListUtil.emptyIfNull(resultSousClassComptables.get(0)).forEach(e -> e.setClassComptable(classComptable));
            sousClassComptableService.update(resultSousClassComptables.get(0),true);
    }
    }



    public void configure() {
        super.configure(ClassComptable.class,ClassComptableHistory.class, ClassComptableHistoryCriteria.class, ClassComptableSpecification.class);
    }

    @Autowired
    private SousClassComptableAdminService sousClassComptableService ;
    public ClassComptableAdminServiceImpl(ClassComptableDao dao, ClassComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}