package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ProprietaireCheque;
import ma.sir.easystock.bean.history.ProprietaireChequeHistory;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeCriteria;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ProprietaireChequeDao;
import ma.sir.easystock.dao.facade.history.ProprietaireChequeHistoryDao;
import ma.sir.easystock.dao.specification.core.ProprietaireChequeSpecification;
import ma.sir.easystock.service.facade.admin.ProprietaireChequeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ProprietaireChequeAdminServiceImpl extends AbstractServiceImpl<ProprietaireCheque,ProprietaireChequeHistory, ProprietaireChequeCriteria, ProprietaireChequeHistoryCriteria, ProprietaireChequeDao,
ProprietaireChequeHistoryDao> implements ProprietaireChequeAdminService {




    public void configure() {
        super.configure(ProprietaireCheque.class,ProprietaireChequeHistory.class, ProprietaireChequeHistoryCriteria.class, ProprietaireChequeSpecification.class);
    }

    public ProprietaireChequeAdminServiceImpl(ProprietaireChequeDao dao, ProprietaireChequeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}