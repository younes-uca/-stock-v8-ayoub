package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.DeclarationIsHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationIsHistoryDao extends AbstractHistoryRepository<DeclarationIsHistory,Long> {

}
