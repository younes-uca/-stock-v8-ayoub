package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.ComptableValidateur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ComptableValidateurDao extends AbstractRepository<ComptableValidateur,Long>  {


}
