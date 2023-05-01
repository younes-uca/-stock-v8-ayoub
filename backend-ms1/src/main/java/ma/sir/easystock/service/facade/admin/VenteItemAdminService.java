package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.VenteItem;
import ma.sir.easystock.dao.criteria.core.VenteItemCriteria;
import ma.sir.easystock.dao.criteria.history.VenteItemHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface VenteItemAdminService extends  IService<VenteItem,VenteItemCriteria, VenteItemHistoryCriteria>  {

    List<VenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<VenteItem> findByVenteId(Long id);
    int deleteByVenteId(Long id);



}
