package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Banque;
import ma.sir.easystock.bean.history.BanqueHistory;
import ma.sir.easystock.dao.criteria.core.BanqueCriteria;
import ma.sir.easystock.dao.criteria.history.BanqueHistoryCriteria;
import ma.sir.easystock.dao.facade.core.BanqueDao;
import ma.sir.easystock.dao.facade.history.BanqueHistoryDao;
import ma.sir.easystock.dao.specification.core.BanqueSpecification;
import ma.sir.easystock.service.facade.admin.BanqueAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class BanqueAdminServiceImpl extends AbstractServiceImpl<Banque,BanqueHistory, BanqueCriteria, BanqueHistoryCriteria, BanqueDao,
BanqueHistoryDao> implements BanqueAdminService {




    public void configure() {
        super.configure(Banque.class,BanqueHistory.class, BanqueHistoryCriteria.class, BanqueSpecification.class);
    }

    public BanqueAdminServiceImpl(BanqueDao dao, BanqueHistoryDao historyDao) {
        super(dao, historyDao);
    }

}