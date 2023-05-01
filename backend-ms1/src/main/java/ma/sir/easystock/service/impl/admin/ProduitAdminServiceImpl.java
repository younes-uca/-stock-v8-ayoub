package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Produit;
import ma.sir.easystock.bean.history.ProduitHistory;
import ma.sir.easystock.dao.criteria.core.ProduitCriteria;
import ma.sir.easystock.dao.criteria.history.ProduitHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ProduitDao;
import ma.sir.easystock.dao.facade.history.ProduitHistoryDao;
import ma.sir.easystock.dao.specification.core.ProduitSpecification;
import ma.sir.easystock.service.facade.admin.ProduitAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.StockProduit;

import ma.sir.easystock.service.facade.admin.CategorieProduitAdminService ;
import ma.sir.easystock.service.facade.admin.UniteMesureAdminService ;
import ma.sir.easystock.service.facade.admin.StockProduitAdminService ;
import ma.sir.easystock.service.facade.admin.MarqueAdminService ;
import ma.sir.easystock.service.facade.admin.StoreAdminService ;


import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit,ProduitHistory, ProduitCriteria, ProduitHistoryCriteria, ProduitDao,
ProduitHistoryDao> implements ProduitAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Produit create(Produit t) {
        super.create(t);
        if (t.getStockProduits() != null) {
                t.getStockProduits().forEach(element-> {
                    element.setProduit(t);
                    stockProduitService.create(element);
            });
        }
        return t;
    }

    public Produit findWithAssociatedLists(Long id){
        Produit result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setStockProduits(stockProduitService.findByProduitId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        stockProduitService.deleteByProduitId(id);
    }


    public void updateWithAssociatedLists(Produit produit){
    if(produit !=null && produit.getId() != null){
            List<List<StockProduit>> resultStockProduits= stockProduitService.getToBeSavedAndToBeDeleted(stockProduitService.findByProduitId(produit.getId()),produit.getStockProduits());
            stockProduitService.delete(resultStockProduits.get(1));
            ListUtil.emptyIfNull(resultStockProduits.get(0)).forEach(e -> e.setProduit(produit));
            stockProduitService.update(resultStockProduits.get(0),true);
    }
    }

    public Produit findByReferenceEntity(Produit t){
        return  dao.findByReference(t.getReference());
    }

    public List<Produit> findByCategorieProduitId(Long id){
        return dao.findByCategorieProduitId(id);
    }
    public int deleteByCategorieProduitId(Long id){
        return dao.deleteByCategorieProduitId(id);
    }
    public List<Produit> findByUniteMesureId(Long id){
        return dao.findByUniteMesureId(id);
    }
    public int deleteByUniteMesureId(Long id){
        return dao.deleteByUniteMesureId(id);
    }
    public List<Produit> findByMarqueId(Long id){
        return dao.findByMarqueId(id);
    }
    public int deleteByMarqueId(Long id){
        return dao.deleteByMarqueId(id);
    }
    public List<Produit> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }

    public void configure() {
        super.configure(Produit.class,ProduitHistory.class, ProduitHistoryCriteria.class, ProduitSpecification.class);
    }

    @Autowired
    private CategorieProduitAdminService categorieProduitService ;
    @Autowired
    private UniteMesureAdminService uniteMesureService ;
    @Autowired
    private StockProduitAdminService stockProduitService ;
    @Autowired
    private MarqueAdminService marqueService ;
    @Autowired
    private StoreAdminService storeService ;
    public ProduitAdminServiceImpl(ProduitDao dao, ProduitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}