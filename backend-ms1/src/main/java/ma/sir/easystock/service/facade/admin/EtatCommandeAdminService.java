package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatCommande;
import ma.sir.easystock.dao.criteria.core.EtatCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatCommandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface EtatCommandeAdminService extends  IService<EtatCommande,EtatCommandeCriteria, EtatCommandeHistoryCriteria>  {




}
