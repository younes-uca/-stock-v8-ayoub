package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiementAchat;
import ma.sir.easystock.bean.history.EtatPaiementAchatHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementAchatHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementAchatDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementAchatHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementAchatSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementAchatAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class EtatPaiementAchatAdminServiceImpl extends AbstractServiceImpl<EtatPaiementAchat,EtatPaiementAchatHistory, EtatPaiementAchatCriteria, EtatPaiementAchatHistoryCriteria, EtatPaiementAchatDao,
EtatPaiementAchatHistoryDao> implements EtatPaiementAchatAdminService {


    public EtatPaiementAchat findByReferenceEntity(EtatPaiementAchat t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(EtatPaiementAchat.class,EtatPaiementAchatHistory.class, EtatPaiementAchatHistoryCriteria.class, EtatPaiementAchatSpecification.class);
    }

    public EtatPaiementAchatAdminServiceImpl(EtatPaiementAchatDao dao, EtatPaiementAchatHistoryDao historyDao) {
        super(dao, historyDao);
    }

}