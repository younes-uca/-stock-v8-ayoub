package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ComptableTraitant;
import ma.sir.easystock.bean.history.ComptableTraitantHistory;
import ma.sir.easystock.dao.criteria.core.ComptableTraitantCriteria;
import ma.sir.easystock.dao.criteria.history.ComptableTraitantHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ComptableTraitantDao;
import ma.sir.easystock.dao.facade.history.ComptableTraitantHistoryDao;
import ma.sir.easystock.dao.specification.core.ComptableTraitantSpecification;
import ma.sir.easystock.service.facade.admin.ComptableTraitantAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ComptableTraitantAdminServiceImpl extends AbstractServiceImpl<ComptableTraitant,ComptableTraitantHistory, ComptableTraitantCriteria, ComptableTraitantHistoryCriteria, ComptableTraitantDao,
ComptableTraitantHistoryDao> implements ComptableTraitantAdminService {




    public void configure() {
        super.configure(ComptableTraitant.class,ComptableTraitantHistory.class, ComptableTraitantHistoryCriteria.class, ComptableTraitantSpecification.class);
    }

    public ComptableTraitantAdminServiceImpl(ComptableTraitantDao dao, ComptableTraitantHistoryDao historyDao) {
        super(dao, historyDao);
    }

}