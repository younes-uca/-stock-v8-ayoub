package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.PaiementVente;
import ma.sir.easystock.dao.criteria.core.PaiementVenteCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementVenteHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

public interface PaiementVenteAdminService extends  IService<PaiementVente,PaiementVenteCriteria, PaiementVenteHistoryCriteria>  {

    List<PaiementVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    List<PaiementVente> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    List<PaiementVente> findByInstrumentPaiementId(Long id);
    int deleteByInstrumentPaiementId(Long id);
    List<PaiementVente> findByEtatPaiementVenteId(Long id);
    int deleteByEtatPaiementVenteId(Long id);



}
