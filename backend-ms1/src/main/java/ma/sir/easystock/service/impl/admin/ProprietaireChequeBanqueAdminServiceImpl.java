package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ProprietaireChequeBanque;
import ma.sir.easystock.bean.history.ProprietaireChequeBanqueHistory;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeBanqueCriteria;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeBanqueHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ProprietaireChequeBanqueDao;
import ma.sir.easystock.dao.facade.history.ProprietaireChequeBanqueHistoryDao;
import ma.sir.easystock.dao.specification.core.ProprietaireChequeBanqueSpecification;
import ma.sir.easystock.service.facade.admin.ProprietaireChequeBanqueAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.ProprietaireChequeAdminService ;
import ma.sir.easystock.service.facade.admin.BanqueAdminService ;


import java.util.List;
@Service
public class ProprietaireChequeBanqueAdminServiceImpl extends AbstractServiceImpl<ProprietaireChequeBanque,ProprietaireChequeBanqueHistory, ProprietaireChequeBanqueCriteria, ProprietaireChequeBanqueHistoryCriteria, ProprietaireChequeBanqueDao,
ProprietaireChequeBanqueHistoryDao> implements ProprietaireChequeBanqueAdminService {



    public List<ProprietaireChequeBanque> findByProprietaireChequeId(Long id){
        return dao.findByProprietaireChequeId(id);
    }
    public int deleteByProprietaireChequeId(Long id){
        return dao.deleteByProprietaireChequeId(id);
    }
    public List<ProprietaireChequeBanque> findByBanqueId(Long id){
        return dao.findByBanqueId(id);
    }
    public int deleteByBanqueId(Long id){
        return dao.deleteByBanqueId(id);
    }

    public void configure() {
        super.configure(ProprietaireChequeBanque.class,ProprietaireChequeBanqueHistory.class, ProprietaireChequeBanqueHistoryCriteria.class, ProprietaireChequeBanqueSpecification.class);
    }

    @Autowired
    private ProprietaireChequeAdminService proprietaireChequeService ;
    @Autowired
    private BanqueAdminService banqueService ;
    public ProprietaireChequeBanqueAdminServiceImpl(ProprietaireChequeBanqueDao dao, ProprietaireChequeBanqueHistoryDao historyDao) {
        super(dao, historyDao);
    }

}