package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Reception;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ReceptionDao extends AbstractRepository<Reception,Long>  {

    List<Reception> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    List<Reception> findByEtatReceptionId(Long id);
    int deleteByEtatReceptionId(Long id);

}
