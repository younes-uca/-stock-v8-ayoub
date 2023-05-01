package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.CommandeItem;
import ma.sir.easystock.dao.criteria.core.CommandeItemCriteria;
import ma.sir.easystock.dao.criteria.history.CommandeItemHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface CommandeItemAdminService extends  IService<CommandeItem,CommandeItemCriteria, CommandeItemHistoryCriteria>  {

    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    List<CommandeItem> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);



}
