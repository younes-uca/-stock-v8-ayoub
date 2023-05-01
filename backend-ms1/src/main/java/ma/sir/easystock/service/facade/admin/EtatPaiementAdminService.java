package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatPaiement;
import ma.sir.easystock.dao.criteria.core.EtatPaiementCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface EtatPaiementAdminService extends  IService<EtatPaiement,EtatPaiementCriteria, EtatPaiementHistoryCriteria>  {




}
