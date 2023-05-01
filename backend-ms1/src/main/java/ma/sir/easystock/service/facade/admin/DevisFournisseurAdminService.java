package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.DevisFournisseur;
import ma.sir.easystock.dao.criteria.core.DevisFournisseurCriteria;
import ma.sir.easystock.dao.criteria.history.DevisFournisseurHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface DevisFournisseurAdminService extends  IService<DevisFournisseur,DevisFournisseurCriteria, DevisFournisseurHistoryCriteria>  {

    List<DevisFournisseur> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);



}
