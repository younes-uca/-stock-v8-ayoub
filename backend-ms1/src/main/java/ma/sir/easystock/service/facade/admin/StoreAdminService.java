package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Store;
import ma.sir.easystock.dao.criteria.core.StoreCriteria;
import ma.sir.easystock.dao.criteria.history.StoreHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface StoreAdminService extends  IService<Store,StoreCriteria, StoreHistoryCriteria>  {

    List<Store> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);



}
