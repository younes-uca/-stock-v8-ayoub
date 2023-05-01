package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Fournisseur;
import ma.sir.easystock.bean.history.FournisseurHistory;
import ma.sir.easystock.dao.criteria.core.FournisseurCriteria;
import ma.sir.easystock.dao.criteria.history.FournisseurHistoryCriteria;
import ma.sir.easystock.dao.facade.core.FournisseurDao;
import ma.sir.easystock.dao.facade.history.FournisseurHistoryDao;
import ma.sir.easystock.dao.specification.core.FournisseurSpecification;
import ma.sir.easystock.service.facade.admin.FournisseurAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class FournisseurAdminServiceImpl extends AbstractServiceImpl<Fournisseur,FournisseurHistory, FournisseurCriteria, FournisseurHistoryCriteria, FournisseurDao,
FournisseurHistoryDao> implements FournisseurAdminService {


    public Fournisseur findByReferenceEntity(Fournisseur t){
        return  dao.findByIce(t.getIce());
    }


    public void configure() {
        super.configure(Fournisseur.class,FournisseurHistory.class, FournisseurHistoryCriteria.class, FournisseurSpecification.class);
    }

    public FournisseurAdminServiceImpl(FournisseurDao dao, FournisseurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}