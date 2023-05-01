package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.DemandeItem;
import ma.sir.easystock.bean.history.DemandeItemHistory;
import ma.sir.easystock.dao.criteria.core.DemandeItemCriteria;
import ma.sir.easystock.dao.criteria.history.DemandeItemHistoryCriteria;
import ma.sir.easystock.dao.facade.core.DemandeItemDao;
import ma.sir.easystock.dao.facade.history.DemandeItemHistoryDao;
import ma.sir.easystock.dao.specification.core.DemandeItemSpecification;
import ma.sir.easystock.service.facade.admin.DemandeItemAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.DemandeAdminService ;
import ma.sir.easystock.service.facade.admin.ProduitAdminService ;


import java.util.List;
@Service
public class DemandeItemAdminServiceImpl extends AbstractServiceImpl<DemandeItem,DemandeItemHistory, DemandeItemCriteria, DemandeItemHistoryCriteria, DemandeItemDao,
DemandeItemHistoryDao> implements DemandeItemAdminService {



    public List<DemandeItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<DemandeItem> findByDemandeId(Long id){
        return dao.findByDemandeId(id);
    }
    public int deleteByDemandeId(Long id){
        return dao.deleteByDemandeId(id);
    }

    public void configure() {
        super.configure(DemandeItem.class,DemandeItemHistory.class, DemandeItemHistoryCriteria.class, DemandeItemSpecification.class);
    }

    @Autowired
    private DemandeAdminService demandeService ;
    @Autowired
    private ProduitAdminService produitService ;
    public DemandeItemAdminServiceImpl(DemandeItemDao dao, DemandeItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}