package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Produit;
import ma.sir.easystock.dao.criteria.core.ProduitCriteria;
import ma.sir.easystock.dao.criteria.history.ProduitHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface ProduitAdminService extends  IService<Produit,ProduitCriteria, ProduitHistoryCriteria>  {

    List<Produit> findByCategorieProduitId(Long id);
    int deleteByCategorieProduitId(Long id);
    List<Produit> findByUniteMesureId(Long id);
    int deleteByUniteMesureId(Long id);
    List<Produit> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);
    List<Produit> findByStoreId(Long id);
    int deleteByStoreId(Long id);



}
