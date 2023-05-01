package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.InstrumentPaiement;
import ma.sir.easystock.bean.history.InstrumentPaiementHistory;
import ma.sir.easystock.dao.criteria.core.InstrumentPaiementCriteria;
import ma.sir.easystock.dao.criteria.history.InstrumentPaiementHistoryCriteria;
import ma.sir.easystock.dao.facade.core.InstrumentPaiementDao;
import ma.sir.easystock.dao.facade.history.InstrumentPaiementHistoryDao;
import ma.sir.easystock.dao.specification.core.InstrumentPaiementSpecification;
import ma.sir.easystock.service.facade.admin.InstrumentPaiementAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class InstrumentPaiementAdminServiceImpl extends AbstractServiceImpl<InstrumentPaiement,InstrumentPaiementHistory, InstrumentPaiementCriteria, InstrumentPaiementHistoryCriteria, InstrumentPaiementDao,
InstrumentPaiementHistoryDao> implements InstrumentPaiementAdminService {


    public InstrumentPaiement findByReferenceEntity(InstrumentPaiement t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(InstrumentPaiement.class,InstrumentPaiementHistory.class, InstrumentPaiementHistoryCriteria.class, InstrumentPaiementSpecification.class);
    }

    public InstrumentPaiementAdminServiceImpl(InstrumentPaiementDao dao, InstrumentPaiementHistoryDao historyDao) {
        super(dao, historyDao);
    }

}