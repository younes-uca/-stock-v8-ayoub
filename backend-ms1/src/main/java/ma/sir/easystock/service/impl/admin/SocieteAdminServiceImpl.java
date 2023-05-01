package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Societe;
import ma.sir.easystock.bean.history.SocieteHistory;
import ma.sir.easystock.dao.criteria.core.SocieteCriteria;
import ma.sir.easystock.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.easystock.dao.facade.core.SocieteDao;
import ma.sir.easystock.dao.facade.history.SocieteHistoryDao;
import ma.sir.easystock.dao.specification.core.SocieteSpecification;
import ma.sir.easystock.service.facade.admin.SocieteAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.Store;

import ma.sir.easystock.service.facade.admin.AbonneAdminService ;
import ma.sir.easystock.service.facade.admin.StoreAdminService ;


import java.util.List;
@Service
public class SocieteAdminServiceImpl extends AbstractServiceImpl<Societe,SocieteHistory, SocieteCriteria, SocieteHistoryCriteria, SocieteDao,
SocieteHistoryDao> implements SocieteAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Societe create(Societe t) {
        super.create(t);
        if (t.getStores() != null) {
                t.getStores().forEach(element-> {
                    element.setSociete(t);
                    storeService.create(element);
            });
        }
        return t;
    }

    public Societe findWithAssociatedLists(Long id){
        Societe result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setStores(storeService.findBySocieteId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        storeService.deleteBySocieteId(id);
    }


    public void updateWithAssociatedLists(Societe societe){
    if(societe !=null && societe.getId() != null){
            List<List<Store>> resultStores= storeService.getToBeSavedAndToBeDeleted(storeService.findBySocieteId(societe.getId()),societe.getStores());
            storeService.delete(resultStores.get(1));
            ListUtil.emptyIfNull(resultStores.get(0)).forEach(e -> e.setSociete(societe));
            storeService.update(resultStores.get(0),true);
    }
    }

    public Societe findByReferenceEntity(Societe t){
        return  dao.findByIce(t.getIce());
    }

    public List<Societe> findByAbonneId(Long id){
        return dao.findByAbonneId(id);
    }
    public int deleteByAbonneId(Long id){
        return dao.deleteByAbonneId(id);
    }

    public void configure() {
        super.configure(Societe.class,SocieteHistory.class, SocieteHistoryCriteria.class, SocieteSpecification.class);
    }

    @Autowired
    private AbonneAdminService abonneService ;
    @Autowired
    private StoreAdminService storeService ;
    public SocieteAdminServiceImpl(SocieteDao dao, SocieteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}