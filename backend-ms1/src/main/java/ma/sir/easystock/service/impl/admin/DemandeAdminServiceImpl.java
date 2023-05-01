package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Demande;
import ma.sir.easystock.bean.history.DemandeHistory;
import ma.sir.easystock.dao.criteria.core.DemandeCriteria;
import ma.sir.easystock.dao.criteria.history.DemandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.DemandeDao;
import ma.sir.easystock.dao.facade.history.DemandeHistoryDao;
import ma.sir.easystock.dao.specification.core.DemandeSpecification;
import ma.sir.easystock.service.facade.admin.DemandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.DemandeItem;
import ma.sir.easystock.bean.core.PaiementDemande;

import ma.sir.easystock.service.facade.admin.EtatDemandeAdminService ;
import ma.sir.easystock.service.facade.admin.ProduitAdminService ;
import ma.sir.easystock.service.facade.admin.DemandeItemAdminService ;
import ma.sir.easystock.service.facade.admin.LivraisonAdminService ;
import ma.sir.easystock.service.facade.admin.PaiementDemandeAdminService ;
import ma.sir.easystock.service.facade.admin.ClientAdminService ;
import ma.sir.easystock.service.facade.admin.MagasinAdminService ;
import ma.sir.easystock.service.facade.admin.StoreAdminService ;


import java.util.List;
@Service
public class DemandeAdminServiceImpl extends AbstractServiceImpl<Demande,DemandeHistory, DemandeCriteria, DemandeHistoryCriteria, DemandeDao,
DemandeHistoryDao> implements DemandeAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Demande create(Demande t) {
        super.create(t);
        if (t.getDemandeItems() != null) {
                t.getDemandeItems().forEach(element-> {
                    element.setDemande(t);
                    demandeItemService.create(element);
            });
        }
        if (t.getPaiementDemandes() != null) {
                t.getPaiementDemandes().forEach(element-> {
                    element.setDemande(t);
                    paiementDemandeService.create(element);
            });
        }
        return t;
    }

    public Demande findWithAssociatedLists(Long id){
        Demande result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setDemandeItems(demandeItemService.findByDemandeId(id));
            result.setPaiementDemandes(paiementDemandeService.findByDemandeId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        demandeItemService.deleteByDemandeId(id);
        paiementDemandeService.deleteByDemandeId(id);
    }


    public void updateWithAssociatedLists(Demande demande){
    if(demande !=null && demande.getId() != null){
            List<List<DemandeItem>> resultDemandeItems= demandeItemService.getToBeSavedAndToBeDeleted(demandeItemService.findByDemandeId(demande.getId()),demande.getDemandeItems());
            demandeItemService.delete(resultDemandeItems.get(1));
            ListUtil.emptyIfNull(resultDemandeItems.get(0)).forEach(e -> e.setDemande(demande));
            demandeItemService.update(resultDemandeItems.get(0),true);
            List<List<PaiementDemande>> resultPaiementDemandes= paiementDemandeService.getToBeSavedAndToBeDeleted(paiementDemandeService.findByDemandeId(demande.getId()),demande.getPaiementDemandes());
            paiementDemandeService.delete(resultPaiementDemandes.get(1));
            ListUtil.emptyIfNull(resultPaiementDemandes.get(0)).forEach(e -> e.setDemande(demande));
            paiementDemandeService.update(resultPaiementDemandes.get(0),true);
    }
    }


    public List<Demande> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<Demande> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Demande> findByLivraisonId(Long id){
        return dao.findByLivraisonId(id);
    }
    public int deleteByLivraisonId(Long id){
        return dao.deleteByLivraisonId(id);
    }
    public List<Demande> findByMagasinId(Long id){
        return dao.findByMagasinId(id);
    }
    public int deleteByMagasinId(Long id){
        return dao.deleteByMagasinId(id);
    }
    public List<Demande> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }
    public List<Demande> findByEtatDemandeId(Long id){
        return dao.findByEtatDemandeId(id);
    }
    public int deleteByEtatDemandeId(Long id){
        return dao.deleteByEtatDemandeId(id);
    }

    public void configure() {
        super.configure(Demande.class,DemandeHistory.class, DemandeHistoryCriteria.class, DemandeSpecification.class);
    }

    @Autowired
    private EtatDemandeAdminService etatDemandeService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private DemandeItemAdminService demandeItemService ;
    @Autowired
    private LivraisonAdminService livraisonService ;
    @Autowired
    private PaiementDemandeAdminService paiementDemandeService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private StoreAdminService storeService ;
    public DemandeAdminServiceImpl(DemandeDao dao, DemandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}