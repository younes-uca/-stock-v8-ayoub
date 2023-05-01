package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiement;
import ma.sir.easystock.bean.history.EtatPaiementHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class EtatPaiementAdminServiceImpl extends AbstractServiceImpl<EtatPaiement,EtatPaiementHistory, EtatPaiementCriteria, EtatPaiementHistoryCriteria, EtatPaiementDao,
EtatPaiementHistoryDao> implements EtatPaiementAdminService {


    public EtatPaiement findByReferenceEntity(EtatPaiement t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(EtatPaiement.class,EtatPaiementHistory.class, EtatPaiementHistoryCriteria.class, EtatPaiementSpecification.class);
    }

    public EtatPaiementAdminServiceImpl(EtatPaiementDao dao, EtatPaiementHistoryDao historyDao) {
        super(dao, historyDao);
    }

}