package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.AvoirAchat;
import ma.sir.easystock.dao.criteria.core.AvoirAchatCriteria;
import ma.sir.easystock.dao.criteria.history.AvoirAchatHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface AvoirAchatAdminService extends  IService<AvoirAchat,AvoirAchatCriteria, AvoirAchatHistoryCriteria>  {

    List<AvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);



}
