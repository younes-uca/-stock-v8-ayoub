package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Demande;
import ma.sir.easystock.dao.criteria.core.DemandeCriteria;
import ma.sir.easystock.dao.criteria.history.DemandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface DemandeAdminService extends  IService<Demande,DemandeCriteria, DemandeHistoryCriteria>  {

    List<Demande> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<Demande> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Demande> findByLivraisonId(Long id);
    int deleteByLivraisonId(Long id);
    List<Demande> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    List<Demande> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<Demande> findByEtatDemandeId(Long id);
    int deleteByEtatDemandeId(Long id);



}
