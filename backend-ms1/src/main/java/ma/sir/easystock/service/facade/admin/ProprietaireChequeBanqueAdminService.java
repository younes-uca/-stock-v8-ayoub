package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.ProprietaireChequeBanque;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeBanqueCriteria;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeBanqueHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface ProprietaireChequeBanqueAdminService extends  IService<ProprietaireChequeBanque,ProprietaireChequeBanqueCriteria, ProprietaireChequeBanqueHistoryCriteria>  {

    List<ProprietaireChequeBanque> findByProprietaireChequeId(Long id);
    int deleteByProprietaireChequeId(Long id);
    List<ProprietaireChequeBanque> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);



}
