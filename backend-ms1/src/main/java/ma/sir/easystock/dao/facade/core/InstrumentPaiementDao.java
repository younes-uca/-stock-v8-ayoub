package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.InstrumentPaiement;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.InstrumentPaiement;
import java.util.List;


@Repository
public interface InstrumentPaiementDao extends AbstractRepository<InstrumentPaiement,Long>  {
    InstrumentPaiement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW InstrumentPaiement(item.id,item.libelle) FROM InstrumentPaiement item")
    List<InstrumentPaiement> findAllOptimized();
}
