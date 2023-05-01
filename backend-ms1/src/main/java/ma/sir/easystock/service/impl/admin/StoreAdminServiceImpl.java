package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Store;
import ma.sir.easystock.bean.history.StoreHistory;
import ma.sir.easystock.dao.criteria.core.StoreCriteria;
import ma.sir.easystock.dao.criteria.history.StoreHistoryCriteria;
import ma.sir.easystock.dao.facade.core.StoreDao;
import ma.sir.easystock.dao.facade.history.StoreHistoryDao;
import ma.sir.easystock.dao.specification.core.StoreSpecification;
import ma.sir.easystock.service.facade.admin.StoreAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.Magasin;

import ma.sir.easystock.service.facade.admin.SocieteAdminService ;
import ma.sir.easystock.service.facade.admin.MagasinAdminService ;


import java.util.List;
@Service
public class StoreAdminServiceImpl extends AbstractServiceImpl<Store,StoreHistory, StoreCriteria, StoreHistoryCriteria, StoreDao,
StoreHistoryDao> implements StoreAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Store create(Store t) {
        super.create(t);
        if (t.getMagasins() != null) {
                t.getMagasins().forEach(element-> {
                    element.setStore(t);
                    magasinService.create(element);
            });
        }
        return t;
    }

    public Store findWithAssociatedLists(Long id){
        Store result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setMagasins(magasinService.findByStoreId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        magasinService.deleteByStoreId(id);
    }


    public void updateWithAssociatedLists(Store store){
    if(store !=null && store.getId() != null){
            List<List<Magasin>> resultMagasins= magasinService.getToBeSavedAndToBeDeleted(magasinService.findByStoreId(store.getId()),store.getMagasins());
            magasinService.delete(resultMagasins.get(1));
            ListUtil.emptyIfNull(resultMagasins.get(0)).forEach(e -> e.setStore(store));
            magasinService.update(resultMagasins.get(0),true);
    }
    }

    public Store findByReferenceEntity(Store t){
        return  dao.findByReference(t.getReference());
    }

    public List<Store> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }

    public void configure() {
        super.configure(Store.class,StoreHistory.class, StoreHistoryCriteria.class, StoreSpecification.class);
    }

    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private MagasinAdminService magasinService ;
    public StoreAdminServiceImpl(StoreDao dao, StoreHistoryDao historyDao) {
        super(dao, historyDao);
    }

}