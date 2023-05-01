package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.PaiementVente;
import ma.sir.easystock.bean.history.PaiementVenteHistory;
import ma.sir.easystock.dao.criteria.core.PaiementVenteCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementVenteHistoryCriteria;
import ma.sir.easystock.dao.facade.core.PaiementVenteDao;
import ma.sir.easystock.dao.facade.history.PaiementVenteHistoryDao;
import ma.sir.easystock.dao.specification.core.PaiementVenteSpecification;
import ma.sir.easystock.service.facade.admin.PaiementVenteAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.EtatPaiementVenteAdminService ;
import ma.sir.easystock.service.facade.admin.InstrumentPaiementAdminService ;
import ma.sir.easystock.service.facade.admin.ModePaiementAdminService ;
import ma.sir.easystock.service.facade.admin.VenteAdminService ;


import java.util.List;
@Service
public class PaiementVenteAdminServiceImpl extends AbstractServiceImpl<PaiementVente,PaiementVenteHistory, PaiementVenteCriteria, PaiementVenteHistoryCriteria, PaiementVenteDao,
PaiementVenteHistoryDao> implements PaiementVenteAdminService {


    public PaiementVente findByReferenceEntity(PaiementVente t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public List<PaiementVente> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public List<PaiementVente> findByInstrumentPaiementId(Long id){
        return dao.findByInstrumentPaiementId(id);
    }
    public int deleteByInstrumentPaiementId(Long id){
        return dao.deleteByInstrumentPaiementId(id);
    }
    public List<PaiementVente> findByEtatPaiementVenteId(Long id){
        return dao.findByEtatPaiementVenteId(id);
    }
    public int deleteByEtatPaiementVenteId(Long id){
        return dao.deleteByEtatPaiementVenteId(id);
    }

    public void configure() {
        super.configure(PaiementVente.class,PaiementVenteHistory.class, PaiementVenteHistoryCriteria.class, PaiementVenteSpecification.class);
    }

    @Autowired
    private EtatPaiementVenteAdminService etatPaiementVenteService ;
    @Autowired
    private InstrumentPaiementAdminService instrumentPaiementService ;
    @Autowired
    private ModePaiementAdminService modePaiementService ;
    @Autowired
    private VenteAdminService venteService ;
    public PaiementVenteAdminServiceImpl(PaiementVenteDao dao, PaiementVenteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}