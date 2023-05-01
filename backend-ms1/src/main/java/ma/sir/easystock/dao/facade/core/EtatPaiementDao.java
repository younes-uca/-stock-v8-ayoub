package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.EtatPaiement;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.EtatPaiement;
import java.util.List;


@Repository
public interface EtatPaiementDao extends AbstractRepository<EtatPaiement,Long>  {
    EtatPaiement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatPaiement(item.id,item.libelle) FROM EtatPaiement item")
    List<EtatPaiement> findAllOptimized();
}
