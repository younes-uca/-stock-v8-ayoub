package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.DevisItemFournisseur;
import ma.sir.easystock.bean.history.DevisItemFournisseurHistory;
import ma.sir.easystock.dao.criteria.core.DevisItemFournisseurCriteria;
import ma.sir.easystock.dao.criteria.history.DevisItemFournisseurHistoryCriteria;
import ma.sir.easystock.dao.facade.core.DevisItemFournisseurDao;
import ma.sir.easystock.dao.facade.history.DevisItemFournisseurHistoryDao;
import ma.sir.easystock.dao.specification.core.DevisItemFournisseurSpecification;
import ma.sir.easystock.service.facade.admin.DevisItemFournisseurAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.ProduitAdminService ;
import ma.sir.easystock.service.facade.admin.DevisFournisseurAdminService ;


import java.util.List;
@Service
public class DevisItemFournisseurAdminServiceImpl extends AbstractServiceImpl<DevisItemFournisseur,DevisItemFournisseurHistory, DevisItemFournisseurCriteria, DevisItemFournisseurHistoryCriteria, DevisItemFournisseurDao,
DevisItemFournisseurHistoryDao> implements DevisItemFournisseurAdminService {



    public List<DevisItemFournisseur> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<DevisItemFournisseur> findByDevisFournisseurId(Long id){
        return dao.findByDevisFournisseurId(id);
    }
    public int deleteByDevisFournisseurId(Long id){
        return dao.deleteByDevisFournisseurId(id);
    }

    public void configure() {
        super.configure(DevisItemFournisseur.class,DevisItemFournisseurHistory.class, DevisItemFournisseurHistoryCriteria.class, DevisItemFournisseurSpecification.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private DevisFournisseurAdminService devisFournisseurService ;
    public DevisItemFournisseurAdminServiceImpl(DevisItemFournisseurDao dao, DevisItemFournisseurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}