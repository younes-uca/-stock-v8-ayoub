package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatReception;
import ma.sir.easystock.bean.history.EtatReceptionHistory;
import ma.sir.easystock.dao.criteria.core.EtatReceptionCriteria;
import ma.sir.easystock.dao.criteria.history.EtatReceptionHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatReceptionDao;
import ma.sir.easystock.dao.facade.history.EtatReceptionHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatReceptionSpecification;
import ma.sir.easystock.service.facade.admin.EtatReceptionAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class EtatReceptionAdminServiceImpl extends AbstractServiceImpl<EtatReception,EtatReceptionHistory, EtatReceptionCriteria, EtatReceptionHistoryCriteria, EtatReceptionDao,
EtatReceptionHistoryDao> implements EtatReceptionAdminService {


    public EtatReception findByReferenceEntity(EtatReception t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(EtatReception.class,EtatReceptionHistory.class, EtatReceptionHistoryCriteria.class, EtatReceptionSpecification.class);
    }

    public EtatReceptionAdminServiceImpl(EtatReceptionDao dao, EtatReceptionHistoryDao historyDao) {
        super(dao, historyDao);
    }

}