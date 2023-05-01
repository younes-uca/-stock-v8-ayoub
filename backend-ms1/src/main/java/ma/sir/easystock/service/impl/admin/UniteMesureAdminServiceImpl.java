package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.UniteMesure;
import ma.sir.easystock.bean.history.UniteMesureHistory;
import ma.sir.easystock.dao.criteria.core.UniteMesureCriteria;
import ma.sir.easystock.dao.criteria.history.UniteMesureHistoryCriteria;
import ma.sir.easystock.dao.facade.core.UniteMesureDao;
import ma.sir.easystock.dao.facade.history.UniteMesureHistoryDao;
import ma.sir.easystock.dao.specification.core.UniteMesureSpecification;
import ma.sir.easystock.service.facade.admin.UniteMesureAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class UniteMesureAdminServiceImpl extends AbstractServiceImpl<UniteMesure,UniteMesureHistory, UniteMesureCriteria, UniteMesureHistoryCriteria, UniteMesureDao,
UniteMesureHistoryDao> implements UniteMesureAdminService {


    public UniteMesure findByReferenceEntity(UniteMesure t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(UniteMesure.class,UniteMesureHistory.class, UniteMesureHistoryCriteria.class, UniteMesureSpecification.class);
    }

    public UniteMesureAdminServiceImpl(UniteMesureDao dao, UniteMesureHistoryDao historyDao) {
        super(dao, historyDao);
    }

}