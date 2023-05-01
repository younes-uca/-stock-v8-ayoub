package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.DevisItemFournisseur;
import ma.sir.easystock.dao.criteria.core.DevisItemFournisseurCriteria;
import ma.sir.easystock.dao.criteria.history.DevisItemFournisseurHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface DevisItemFournisseurAdminService extends  IService<DevisItemFournisseur,DevisItemFournisseurCriteria, DevisItemFournisseurHistoryCriteria>  {

    List<DevisItemFournisseur> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<DevisItemFournisseur> findByDevisFournisseurId(Long id);
    int deleteByDevisFournisseurId(Long id);



}
