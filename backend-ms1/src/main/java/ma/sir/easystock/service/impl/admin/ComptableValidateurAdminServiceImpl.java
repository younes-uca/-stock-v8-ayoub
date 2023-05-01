package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ComptableValidateur;
import ma.sir.easystock.bean.history.ComptableValidateurHistory;
import ma.sir.easystock.dao.criteria.core.ComptableValidateurCriteria;
import ma.sir.easystock.dao.criteria.history.ComptableValidateurHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ComptableValidateurDao;
import ma.sir.easystock.dao.facade.history.ComptableValidateurHistoryDao;
import ma.sir.easystock.dao.specification.core.ComptableValidateurSpecification;
import ma.sir.easystock.service.facade.admin.ComptableValidateurAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ComptableValidateurAdminServiceImpl extends AbstractServiceImpl<ComptableValidateur,ComptableValidateurHistory, ComptableValidateurCriteria, ComptableValidateurHistoryCriteria, ComptableValidateurDao,
ComptableValidateurHistoryDao> implements ComptableValidateurAdminService {




    public void configure() {
        super.configure(ComptableValidateur.class,ComptableValidateurHistory.class, ComptableValidateurHistoryCriteria.class, ComptableValidateurSpecification.class);
    }

    public ComptableValidateurAdminServiceImpl(ComptableValidateurDao dao, ComptableValidateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}