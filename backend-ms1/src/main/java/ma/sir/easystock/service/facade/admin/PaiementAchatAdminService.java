package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.PaiementAchat;
import ma.sir.easystock.dao.criteria.core.PaiementAchatCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementAchatHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface PaiementAchatAdminService extends  IService<PaiementAchat,PaiementAchatCriteria, PaiementAchatHistoryCriteria>  {

    List<PaiementAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    List<PaiementAchat> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    List<PaiementAchat> findByInstrumentPaiementId(Long id);
    int deleteByInstrumentPaiementId(Long id);
    List<PaiementAchat> findByEtatPaiementAchatId(Long id);
    int deleteByEtatPaiementAchatId(Long id);



}
