package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Demande;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DemandeDao extends AbstractRepository<Demande,Long>  {

    List<Demande> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<Demande> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Demande> findByLivraisonId(Long id);
    int deleteByLivraisonId(Long id);
    List<Demande> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    List<Demande> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<Demande> findByEtatDemandeId(Long id);
    int deleteByEtatDemandeId(Long id);

}
