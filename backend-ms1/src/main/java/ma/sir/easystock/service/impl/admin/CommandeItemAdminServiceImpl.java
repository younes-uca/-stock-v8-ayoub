package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.CommandeItem;
import ma.sir.easystock.bean.history.CommandeItemHistory;
import ma.sir.easystock.dao.criteria.core.CommandeItemCriteria;
import ma.sir.easystock.dao.criteria.history.CommandeItemHistoryCriteria;
import ma.sir.easystock.dao.facade.core.CommandeItemDao;
import ma.sir.easystock.dao.facade.history.CommandeItemHistoryDao;
import ma.sir.easystock.dao.specification.core.CommandeItemSpecification;
import ma.sir.easystock.service.facade.admin.CommandeItemAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.ProduitAdminService ;
import ma.sir.easystock.service.facade.admin.EtatCommandeAdminService ;
import ma.sir.easystock.service.facade.admin.CommandeAdminService ;


import java.util.List;
@Service
public class CommandeItemAdminServiceImpl extends AbstractServiceImpl<CommandeItem,CommandeItemHistory, CommandeItemCriteria, CommandeItemHistoryCriteria, CommandeItemDao,
CommandeItemHistoryDao> implements CommandeItemAdminService {



    public List<CommandeItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<CommandeItem> findByCommandeId(Long id){
        return dao.findByCommandeId(id);
    }
    public int deleteByCommandeId(Long id){
        return dao.deleteByCommandeId(id);
    }
    public List<CommandeItem> findByEtatCommandeId(Long id){
        return dao.findByEtatCommandeId(id);
    }
    public int deleteByEtatCommandeId(Long id){
        return dao.deleteByEtatCommandeId(id);
    }

    public void configure() {
        super.configure(CommandeItem.class,CommandeItemHistory.class, CommandeItemHistoryCriteria.class, CommandeItemSpecification.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private EtatCommandeAdminService etatCommandeService ;
    @Autowired
    private CommandeAdminService commandeService ;
    public CommandeItemAdminServiceImpl(CommandeItemDao dao, CommandeItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}