package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.PaiementCommande;
import ma.sir.easystock.bean.history.PaiementCommandeHistory;
import ma.sir.easystock.dao.criteria.core.PaiementCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementCommandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.PaiementCommandeDao;
import ma.sir.easystock.dao.facade.history.PaiementCommandeHistoryDao;
import ma.sir.easystock.dao.specification.core.PaiementCommandeSpecification;
import ma.sir.easystock.service.facade.admin.PaiementCommandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.EtatPaiementCommandeAdminService ;
import ma.sir.easystock.service.facade.admin.CommandeAdminService ;
import ma.sir.easystock.service.facade.admin.InstrumentPaiementAdminService ;
import ma.sir.easystock.service.facade.admin.ModePaiementAdminService ;


import java.util.List;
@Service
public class PaiementCommandeAdminServiceImpl extends AbstractServiceImpl<PaiementCommande,PaiementCommandeHistory, PaiementCommandeCriteria, PaiementCommandeHistoryCriteria, PaiementCommandeDao,
PaiementCommandeHistoryDao> implements PaiementCommandeAdminService {


    public PaiementCommande findByReferenceEntity(PaiementCommande t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementCommande> findByCommandeId(Long id){
        return dao.findByCommandeId(id);
    }
    public int deleteByCommandeId(Long id){
        return dao.deleteByCommandeId(id);
    }
    public List<PaiementCommande> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public List<PaiementCommande> findByInstrumentPaiementId(Long id){
        return dao.findByInstrumentPaiementId(id);
    }
    public int deleteByInstrumentPaiementId(Long id){
        return dao.deleteByInstrumentPaiementId(id);
    }
    public List<PaiementCommande> findByEtatPaiementCommandeId(Long id){
        return dao.findByEtatPaiementCommandeId(id);
    }
    public int deleteByEtatPaiementCommandeId(Long id){
        return dao.deleteByEtatPaiementCommandeId(id);
    }

    public void configure() {
        super.configure(PaiementCommande.class,PaiementCommandeHistory.class, PaiementCommandeHistoryCriteria.class, PaiementCommandeSpecification.class);
    }

    @Autowired
    private EtatPaiementCommandeAdminService etatPaiementCommandeService ;
    @Autowired
    private CommandeAdminService commandeService ;
    @Autowired
    private InstrumentPaiementAdminService instrumentPaiementService ;
    @Autowired
    private ModePaiementAdminService modePaiementService ;
    public PaiementCommandeAdminServiceImpl(PaiementCommandeDao dao, PaiementCommandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}