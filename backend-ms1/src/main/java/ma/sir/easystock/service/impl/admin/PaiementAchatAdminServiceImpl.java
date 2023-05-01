package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.PaiementAchat;
import ma.sir.easystock.bean.history.PaiementAchatHistory;
import ma.sir.easystock.dao.criteria.core.PaiementAchatCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementAchatHistoryCriteria;
import ma.sir.easystock.dao.facade.core.PaiementAchatDao;
import ma.sir.easystock.dao.facade.history.PaiementAchatHistoryDao;
import ma.sir.easystock.dao.specification.core.PaiementAchatSpecification;
import ma.sir.easystock.service.facade.admin.PaiementAchatAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.AchatAdminService ;
import ma.sir.easystock.service.facade.admin.InstrumentPaiementAdminService ;
import ma.sir.easystock.service.facade.admin.ModePaiementAdminService ;
import ma.sir.easystock.service.facade.admin.EtatPaiementAchatAdminService ;


import java.util.List;
@Service
public class PaiementAchatAdminServiceImpl extends AbstractServiceImpl<PaiementAchat,PaiementAchatHistory, PaiementAchatCriteria, PaiementAchatHistoryCriteria, PaiementAchatDao,
PaiementAchatHistoryDao> implements PaiementAchatAdminService {


    public PaiementAchat findByReferenceEntity(PaiementAchat t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public List<PaiementAchat> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public List<PaiementAchat> findByInstrumentPaiementId(Long id){
        return dao.findByInstrumentPaiementId(id);
    }
    public int deleteByInstrumentPaiementId(Long id){
        return dao.deleteByInstrumentPaiementId(id);
    }
    public List<PaiementAchat> findByEtatPaiementAchatId(Long id){
        return dao.findByEtatPaiementAchatId(id);
    }
    public int deleteByEtatPaiementAchatId(Long id){
        return dao.deleteByEtatPaiementAchatId(id);
    }

    public void configure() {
        super.configure(PaiementAchat.class,PaiementAchatHistory.class, PaiementAchatHistoryCriteria.class, PaiementAchatSpecification.class);
    }

    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private InstrumentPaiementAdminService instrumentPaiementService ;
    @Autowired
    private ModePaiementAdminService modePaiementService ;
    @Autowired
    private EtatPaiementAchatAdminService etatPaiementAchatService ;
    public PaiementAchatAdminServiceImpl(PaiementAchatDao dao, PaiementAchatHistoryDao historyDao) {
        super(dao, historyDao);
    }

}