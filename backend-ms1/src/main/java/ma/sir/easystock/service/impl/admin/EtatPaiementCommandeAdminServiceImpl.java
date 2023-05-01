package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiementCommande;
import ma.sir.easystock.bean.history.EtatPaiementCommandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementCommandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementCommandeDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementCommandeHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementCommandeSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementCommandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class EtatPaiementCommandeAdminServiceImpl extends AbstractServiceImpl<EtatPaiementCommande,EtatPaiementCommandeHistory, EtatPaiementCommandeCriteria, EtatPaiementCommandeHistoryCriteria, EtatPaiementCommandeDao,
EtatPaiementCommandeHistoryDao> implements EtatPaiementCommandeAdminService {


    public EtatPaiementCommande findByReferenceEntity(EtatPaiementCommande t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(EtatPaiementCommande.class,EtatPaiementCommandeHistory.class, EtatPaiementCommandeHistoryCriteria.class, EtatPaiementCommandeSpecification.class);
    }

    public EtatPaiementCommandeAdminServiceImpl(EtatPaiementCommandeDao dao, EtatPaiementCommandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}