package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatLivraison;
import ma.sir.easystock.bean.history.EtatLivraisonHistory;
import ma.sir.easystock.dao.criteria.core.EtatLivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.EtatLivraisonHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatLivraisonDao;
import ma.sir.easystock.dao.facade.history.EtatLivraisonHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatLivraisonSpecification;
import ma.sir.easystock.service.facade.admin.EtatLivraisonAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class EtatLivraisonAdminServiceImpl extends AbstractServiceImpl<EtatLivraison,EtatLivraisonHistory, EtatLivraisonCriteria, EtatLivraisonHistoryCriteria, EtatLivraisonDao,
EtatLivraisonHistoryDao> implements EtatLivraisonAdminService {


    public EtatLivraison findByReferenceEntity(EtatLivraison t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(EtatLivraison.class,EtatLivraisonHistory.class, EtatLivraisonHistoryCriteria.class, EtatLivraisonSpecification.class);
    }

    public EtatLivraisonAdminServiceImpl(EtatLivraisonDao dao, EtatLivraisonHistoryDao historyDao) {
        super(dao, historyDao);
    }

}