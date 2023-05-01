package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Commande;
import ma.sir.easystock.bean.history.CommandeHistory;
import ma.sir.easystock.dao.criteria.core.CommandeCriteria;
import ma.sir.easystock.dao.criteria.history.CommandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.CommandeDao;
import ma.sir.easystock.dao.facade.history.CommandeHistoryDao;
import ma.sir.easystock.dao.specification.core.CommandeSpecification;
import ma.sir.easystock.service.facade.admin.CommandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.Reception;
import ma.sir.easystock.bean.core.CommandeItem;

import ma.sir.easystock.service.facade.admin.PaiementCommandeAdminService ;
import ma.sir.easystock.service.facade.admin.EtatCommandeAdminService ;
import ma.sir.easystock.service.facade.admin.ReceptionAdminService ;
import ma.sir.easystock.service.facade.admin.CommandeItemAdminService ;
import ma.sir.easystock.service.facade.admin.ClientAdminService ;
import ma.sir.easystock.service.facade.admin.StoreAdminService ;


import java.util.List;
@Service
public class CommandeAdminServiceImpl extends AbstractServiceImpl<Commande,CommandeHistory, CommandeCriteria, CommandeHistoryCriteria, CommandeDao,
CommandeHistoryDao> implements CommandeAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Commande create(Commande t) {
        super.create(t);
        if (t.getReceptions() != null) {
                t.getReceptions().forEach(element-> {
                    element.setCommande(t);
                    receptionService.create(element);
            });
        }
        if (t.getCommandeItems() != null) {
                t.getCommandeItems().forEach(element-> {
                    element.setCommande(t);
                    commandeItemService.create(element);
            });
        }
        return t;
    }

    public Commande findWithAssociatedLists(Long id){
        Commande result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setReceptions(receptionService.findByCommandeId(id));
            result.setCommandeItems(commandeItemService.findByCommandeId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        receptionService.deleteByCommandeId(id);
        commandeItemService.deleteByCommandeId(id);
    }


    public void updateWithAssociatedLists(Commande commande){
    if(commande !=null && commande.getId() != null){
            List<List<Reception>> resultReceptions= receptionService.getToBeSavedAndToBeDeleted(receptionService.findByCommandeId(commande.getId()),commande.getReceptions());
            receptionService.delete(resultReceptions.get(1));
            ListUtil.emptyIfNull(resultReceptions.get(0)).forEach(e -> e.setCommande(commande));
            receptionService.update(resultReceptions.get(0),true);
            List<List<CommandeItem>> resultCommandeItems= commandeItemService.getToBeSavedAndToBeDeleted(commandeItemService.findByCommandeId(commande.getId()),commande.getCommandeItems());
            commandeItemService.delete(resultCommandeItems.get(1));
            ListUtil.emptyIfNull(resultCommandeItems.get(0)).forEach(e -> e.setCommande(commande));
            commandeItemService.update(resultCommandeItems.get(0),true);
    }
    }

    public Commande findByReferenceEntity(Commande t){
        return  dao.findByReference(t.getReference());
    }

    public List<Commande> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Commande> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }
    public List<Commande> findByEtatCommandeId(Long id){
        return dao.findByEtatCommandeId(id);
    }
    public int deleteByEtatCommandeId(Long id){
        return dao.deleteByEtatCommandeId(id);
    }
    public List<Commande> findByPaiementCommandeId(Long id){
        return dao.findByPaiementCommandeId(id);
    }
    public int deleteByPaiementCommandeId(Long id){
        return dao.deleteByPaiementCommandeId(id);
    }

    public void configure() {
        super.configure(Commande.class,CommandeHistory.class, CommandeHistoryCriteria.class, CommandeSpecification.class);
    }

    @Autowired
    private PaiementCommandeAdminService paiementCommandeService ;
    @Autowired
    private EtatCommandeAdminService etatCommandeService ;
    @Autowired
    private ReceptionAdminService receptionService ;
    @Autowired
    private CommandeItemAdminService commandeItemService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private StoreAdminService storeService ;
    public CommandeAdminServiceImpl(CommandeDao dao, CommandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}