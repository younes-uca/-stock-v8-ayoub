package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.TauxRetardTva;
import ma.sir.easystock.bean.history.TauxRetardTvaHistory;
import ma.sir.easystock.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.easystock.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.easystock.dao.facade.core.TauxRetardTvaDao;
import ma.sir.easystock.dao.facade.history.TauxRetardTvaHistoryDao;
import ma.sir.easystock.dao.specification.core.TauxRetardTvaSpecification;
import ma.sir.easystock.service.facade.admin.TauxRetardTvaAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class TauxRetardTvaAdminServiceImpl extends AbstractServiceImpl<TauxRetardTva,TauxRetardTvaHistory, TauxRetardTvaCriteria, TauxRetardTvaHistoryCriteria, TauxRetardTvaDao,
TauxRetardTvaHistoryDao> implements TauxRetardTvaAdminService {




    public void configure() {
        super.configure(TauxRetardTva.class,TauxRetardTvaHistory.class, TauxRetardTvaHistoryCriteria.class, TauxRetardTvaSpecification.class);
    }

    public TauxRetardTvaAdminServiceImpl(TauxRetardTvaDao dao, TauxRetardTvaHistoryDao historyDao) {
        super(dao, historyDao);
    }

}