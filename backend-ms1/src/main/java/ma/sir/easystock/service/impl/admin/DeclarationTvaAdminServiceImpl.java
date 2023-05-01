package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.DeclarationTva;
import ma.sir.easystock.bean.history.DeclarationTvaHistory;
import ma.sir.easystock.dao.criteria.core.DeclarationTvaCriteria;
import ma.sir.easystock.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.easystock.dao.facade.core.DeclarationTvaDao;
import ma.sir.easystock.dao.facade.history.DeclarationTvaHistoryDao;
import ma.sir.easystock.dao.specification.core.DeclarationTvaSpecification;
import ma.sir.easystock.service.facade.admin.DeclarationTvaAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.SocieteAdminService ;
import ma.sir.easystock.service.facade.admin.TauxRetardTvaAdminService ;
import ma.sir.easystock.service.facade.admin.ComptableValidateurAdminService ;
import ma.sir.easystock.service.facade.admin.ComptableTraitantAdminService ;


import java.util.List;
@Service
public class DeclarationTvaAdminServiceImpl extends AbstractServiceImpl<DeclarationTva,DeclarationTvaHistory, DeclarationTvaCriteria, DeclarationTvaHistoryCriteria, DeclarationTvaDao,
DeclarationTvaHistoryDao> implements DeclarationTvaAdminService {



    public List<DeclarationTva> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<DeclarationTva> findByTauxRetardTvaId(Long id){
        return dao.findByTauxRetardTvaId(id);
    }
    public int deleteByTauxRetardTvaId(Long id){
        return dao.deleteByTauxRetardTvaId(id);
    }
    public List<DeclarationTva> findByComptableTraitantId(Long id){
        return dao.findByComptableTraitantId(id);
    }
    public int deleteByComptableTraitantId(Long id){
        return dao.deleteByComptableTraitantId(id);
    }
    public List<DeclarationTva> findByComptableValidateurId(Long id){
        return dao.findByComptableValidateurId(id);
    }
    public int deleteByComptableValidateurId(Long id){
        return dao.deleteByComptableValidateurId(id);
    }

    public void configure() {
        super.configure(DeclarationTva.class,DeclarationTvaHistory.class, DeclarationTvaHistoryCriteria.class, DeclarationTvaSpecification.class);
    }

    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private TauxRetardTvaAdminService tauxRetardTvaService ;
    @Autowired
    private ComptableValidateurAdminService comptableValidateurService ;
    @Autowired
    private ComptableTraitantAdminService comptableTraitantService ;
    public DeclarationTvaAdminServiceImpl(DeclarationTvaDao dao, DeclarationTvaHistoryDao historyDao) {
        super(dao, historyDao);
    }

}