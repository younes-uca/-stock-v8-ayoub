package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiementVente;
import ma.sir.easystock.bean.history.EtatPaiementVenteHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementVenteHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementVenteDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementVenteHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementVenteSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementVenteAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class EtatPaiementVenteAdminServiceImpl extends AbstractServiceImpl<EtatPaiementVente,EtatPaiementVenteHistory, EtatPaiementVenteCriteria, EtatPaiementVenteHistoryCriteria, EtatPaiementVenteDao,
EtatPaiementVenteHistoryDao> implements EtatPaiementVenteAdminService {


    public EtatPaiementVente findByReferenceEntity(EtatPaiementVente t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(EtatPaiementVente.class,EtatPaiementVenteHistory.class, EtatPaiementVenteHistoryCriteria.class, EtatPaiementVenteSpecification.class);
    }

    public EtatPaiementVenteAdminServiceImpl(EtatPaiementVenteDao dao, EtatPaiementVenteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}