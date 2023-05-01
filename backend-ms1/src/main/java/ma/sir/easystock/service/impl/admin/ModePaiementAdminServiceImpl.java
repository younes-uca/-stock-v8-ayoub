package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ModePaiement;
import ma.sir.easystock.bean.history.ModePaiementHistory;
import ma.sir.easystock.dao.criteria.core.ModePaiementCriteria;
import ma.sir.easystock.dao.criteria.history.ModePaiementHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ModePaiementDao;
import ma.sir.easystock.dao.facade.history.ModePaiementHistoryDao;
import ma.sir.easystock.dao.specification.core.ModePaiementSpecification;
import ma.sir.easystock.service.facade.admin.ModePaiementAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ModePaiementAdminServiceImpl extends AbstractServiceImpl<ModePaiement,ModePaiementHistory, ModePaiementCriteria, ModePaiementHistoryCriteria, ModePaiementDao,
ModePaiementHistoryDao> implements ModePaiementAdminService {


    public ModePaiement findByReferenceEntity(ModePaiement t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(ModePaiement.class,ModePaiementHistory.class, ModePaiementHistoryCriteria.class, ModePaiementSpecification.class);
    }

    public ModePaiementAdminServiceImpl(ModePaiementDao dao, ModePaiementHistoryDao historyDao) {
        super(dao, historyDao);
    }

}