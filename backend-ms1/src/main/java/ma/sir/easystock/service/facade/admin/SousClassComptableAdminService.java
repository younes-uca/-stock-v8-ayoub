package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.SousClassComptable;
import ma.sir.easystock.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.easystock.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface SousClassComptableAdminService extends  IService<SousClassComptable,SousClassComptableCriteria, SousClassComptableHistoryCriteria>  {

    List<SousClassComptable> findByClassComptableId(Long id);
    int deleteByClassComptableId(Long id);



}
