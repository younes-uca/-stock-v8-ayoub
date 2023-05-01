package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.LivraisonItem;
import ma.sir.easystock.bean.history.LivraisonItemHistory;
import ma.sir.easystock.dao.criteria.core.LivraisonItemCriteria;
import ma.sir.easystock.dao.criteria.history.LivraisonItemHistoryCriteria;
import ma.sir.easystock.dao.facade.core.LivraisonItemDao;
import ma.sir.easystock.dao.facade.history.LivraisonItemHistoryDao;
import ma.sir.easystock.dao.specification.core.LivraisonItemSpecification;
import ma.sir.easystock.service.facade.admin.LivraisonItemAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.ProduitAdminService ;
import ma.sir.easystock.service.facade.admin.LivraisonAdminService ;


import java.util.List;
@Service
public class LivraisonItemAdminServiceImpl extends AbstractServiceImpl<LivraisonItem,LivraisonItemHistory, LivraisonItemCriteria, LivraisonItemHistoryCriteria, LivraisonItemDao,
LivraisonItemHistoryDao> implements LivraisonItemAdminService {



    public List<LivraisonItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<LivraisonItem> findByLivraisonId(Long id){
        return dao.findByLivraisonId(id);
    }
    public int deleteByLivraisonId(Long id){
        return dao.deleteByLivraisonId(id);
    }

    public void configure() {
        super.configure(LivraisonItem.class,LivraisonItemHistory.class, LivraisonItemHistoryCriteria.class, LivraisonItemSpecification.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private LivraisonAdminService livraisonService ;
    public LivraisonItemAdminServiceImpl(LivraisonItemDao dao, LivraisonItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}