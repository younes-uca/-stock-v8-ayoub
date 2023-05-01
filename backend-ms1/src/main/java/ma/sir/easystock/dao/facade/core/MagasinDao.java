package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Magasin;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MagasinDao extends AbstractRepository<Magasin,Long>  {

    List<Magasin> findByStoreId(Long id);
    int deleteByStoreId(Long id);

}
