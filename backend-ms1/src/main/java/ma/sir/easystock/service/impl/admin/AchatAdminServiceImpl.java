package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Achat;
import ma.sir.easystock.bean.history.AchatHistory;
import ma.sir.easystock.dao.criteria.core.AchatCriteria;
import ma.sir.easystock.dao.criteria.history.AchatHistoryCriteria;
import ma.sir.easystock.dao.facade.core.AchatDao;
import ma.sir.easystock.dao.facade.history.AchatHistoryDao;
import ma.sir.easystock.dao.specification.core.AchatSpecification;
import ma.sir.easystock.service.facade.admin.AchatAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.PaiementAchat;
import ma.sir.easystock.bean.core.AchatItem;
import ma.sir.easystock.bean.core.AvoirAchat;

import ma.sir.easystock.service.facade.admin.PaiementAchatAdminService ;
import ma.sir.easystock.service.facade.admin.AvoirAchatAdminService ;
import ma.sir.easystock.service.facade.admin.AchatItemAdminService ;
import ma.sir.easystock.service.facade.admin.FournisseurAdminService ;
import ma.sir.easystock.service.facade.admin.StoreAdminService ;


import java.util.List;
@Service
public class AchatAdminServiceImpl extends AbstractServiceImpl<Achat,AchatHistory, AchatCriteria, AchatHistoryCriteria, AchatDao,
AchatHistoryDao> implements AchatAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Achat create(Achat t) {
        super.create(t);
        if (t.getPaiementAchats() != null) {
                t.getPaiementAchats().forEach(element-> {
                    element.setAchat(t);
                    paiementAchatService.create(element);
            });
        }
        if (t.getAchatItems() != null) {
                t.getAchatItems().forEach(element-> {
                    element.setAchat(t);
                    achatItemService.create(element);
            });
        }
        if (t.getAvoirAchats() != null) {
                t.getAvoirAchats().forEach(element-> {
                    element.setAchat(t);
                    avoirAchatService.create(element);
            });
        }
        return t;
    }

    public Achat findWithAssociatedLists(Long id){
        Achat result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPaiementAchats(paiementAchatService.findByAchatId(id));
            result.setAchatItems(achatItemService.findByAchatId(id));
            result.setAvoirAchats(avoirAchatService.findByAchatId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        paiementAchatService.deleteByAchatId(id);
        achatItemService.deleteByAchatId(id);
        avoirAchatService.deleteByAchatId(id);
    }


    public void updateWithAssociatedLists(Achat achat){
    if(achat !=null && achat.getId() != null){
            List<List<PaiementAchat>> resultPaiementAchats= paiementAchatService.getToBeSavedAndToBeDeleted(paiementAchatService.findByAchatId(achat.getId()),achat.getPaiementAchats());
            paiementAchatService.delete(resultPaiementAchats.get(1));
            ListUtil.emptyIfNull(resultPaiementAchats.get(0)).forEach(e -> e.setAchat(achat));
            paiementAchatService.update(resultPaiementAchats.get(0),true);
            List<List<AchatItem>> resultAchatItems= achatItemService.getToBeSavedAndToBeDeleted(achatItemService.findByAchatId(achat.getId()),achat.getAchatItems());
            achatItemService.delete(resultAchatItems.get(1));
            ListUtil.emptyIfNull(resultAchatItems.get(0)).forEach(e -> e.setAchat(achat));
            achatItemService.update(resultAchatItems.get(0),true);
            List<List<AvoirAchat>> resultAvoirAchats= avoirAchatService.getToBeSavedAndToBeDeleted(avoirAchatService.findByAchatId(achat.getId()),achat.getAvoirAchats());
            avoirAchatService.delete(resultAvoirAchats.get(1));
            ListUtil.emptyIfNull(resultAvoirAchats.get(0)).forEach(e -> e.setAchat(achat));
            avoirAchatService.update(resultAvoirAchats.get(0),true);
    }
    }

    public Achat findByReferenceEntity(Achat t){
        return  dao.findByReference(t.getReference());
    }

    public List<Achat> findByFournisseurId(Long id){
        return dao.findByFournisseurId(id);
    }
    public int deleteByFournisseurId(Long id){
        return dao.deleteByFournisseurId(id);
    }
    public List<Achat> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }

    public void configure() {
        super.configure(Achat.class,AchatHistory.class, AchatHistoryCriteria.class, AchatSpecification.class);
    }

    @Autowired
    private PaiementAchatAdminService paiementAchatService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;
    @Autowired
    private AchatItemAdminService achatItemService ;
    @Autowired
    private FournisseurAdminService fournisseurService ;
    @Autowired
    private StoreAdminService storeService ;
    public AchatAdminServiceImpl(AchatDao dao, AchatHistoryDao historyDao) {
        super(dao, historyDao);
    }

}