package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Commande;
import ma.sir.easystock.dao.criteria.core.CommandeCriteria;
import ma.sir.easystock.dao.criteria.history.CommandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface CommandeAdminService extends  IService<Commande,CommandeCriteria, CommandeHistoryCriteria>  {

    List<Commande> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Commande> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<Commande> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);
    List<Commande> findByPaiementCommandeId(Long id);
    int deleteByPaiementCommandeId(Long id);



}
