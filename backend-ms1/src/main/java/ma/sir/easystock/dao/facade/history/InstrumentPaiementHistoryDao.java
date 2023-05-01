package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.InstrumentPaiementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentPaiementHistoryDao extends AbstractHistoryRepository<InstrumentPaiementHistory,Long> {

}
