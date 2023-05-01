package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.SousClassComptable;
import ma.sir.easystock.bean.history.SousClassComptableHistory;
import ma.sir.easystock.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.easystock.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.easystock.dao.facade.core.SousClassComptableDao;
import ma.sir.easystock.dao.facade.history.SousClassComptableHistoryDao;
import ma.sir.easystock.dao.specification.core.SousClassComptableSpecification;
import ma.sir.easystock.service.facade.admin.SousClassComptableAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.CompteComptable;

import ma.sir.easystock.service.facade.admin.ClassComptableAdminService ;
import ma.sir.easystock.service.facade.admin.CompteComptableAdminService ;


import java.util.List;
@Service
public class SousClassComptableAdminServiceImpl extends AbstractServiceImpl<SousClassComptable,SousClassComptableHistory, SousClassComptableCriteria, SousClassComptableHistoryCriteria, SousClassComptableDao,
SousClassComptableHistoryDao> implements SousClassComptableAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public SousClassComptable create(SousClassComptable t) {
        super.create(t);
        if (t.getCompteComptables() != null) {
                t.getCompteComptables().forEach(element-> {
                    element.setSousClassComptable(t);
                    compteComptableService.create(element);
            });
        }
        return t;
    }

    public SousClassComptable findWithAssociatedLists(Long id){
        SousClassComptable result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setCompteComptables(compteComptableService.findBySousClassComptableId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        compteComptableService.deleteBySousClassComptableId(id);
    }


    public void updateWithAssociatedLists(SousClassComptable sousClassComptable){
    if(sousClassComptable !=null && sousClassComptable.getId() != null){
            List<List<CompteComptable>> resultCompteComptables= compteComptableService.getToBeSavedAndToBeDeleted(compteComptableService.findBySousClassComptableId(sousClassComptable.getId()),sousClassComptable.getCompteComptables());
            compteComptableService.delete(resultCompteComptables.get(1));
            ListUtil.emptyIfNull(resultCompteComptables.get(0)).forEach(e -> e.setSousClassComptable(sousClassComptable));
            compteComptableService.update(resultCompteComptables.get(0),true);
    }
    }


    public List<SousClassComptable> findByClassComptableId(Long id){
        return dao.findByClassComptableId(id);
    }
    public int deleteByClassComptableId(Long id){
        return dao.deleteByClassComptableId(id);
    }

    public void configure() {
        super.configure(SousClassComptable.class,SousClassComptableHistory.class, SousClassComptableHistoryCriteria.class, SousClassComptableSpecification.class);
    }

    @Autowired
    private ClassComptableAdminService classComptableService ;
    @Autowired
    private CompteComptableAdminService compteComptableService ;
    public SousClassComptableAdminServiceImpl(SousClassComptableDao dao, SousClassComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}