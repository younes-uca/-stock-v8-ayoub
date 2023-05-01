package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Marque;
import ma.sir.easystock.bean.history.MarqueHistory;
import ma.sir.easystock.dao.criteria.core.MarqueCriteria;
import ma.sir.easystock.dao.criteria.history.MarqueHistoryCriteria;
import ma.sir.easystock.dao.facade.core.MarqueDao;
import ma.sir.easystock.dao.facade.history.MarqueHistoryDao;
import ma.sir.easystock.dao.specification.core.MarqueSpecification;
import ma.sir.easystock.service.facade.admin.MarqueAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class MarqueAdminServiceImpl extends AbstractServiceImpl<Marque,MarqueHistory, MarqueCriteria, MarqueHistoryCriteria, MarqueDao,
MarqueHistoryDao> implements MarqueAdminService {


    public Marque findByReferenceEntity(Marque t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(Marque.class,MarqueHistory.class, MarqueHistoryCriteria.class, MarqueSpecification.class);
    }

    public MarqueAdminServiceImpl(MarqueDao dao, MarqueHistoryDao historyDao) {
        super(dao, historyDao);
    }

}