package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.InstrumentPaiementHistoryCriteria;
import ma.sir.easystock.bean.history.InstrumentPaiementHistory;


public class InstrumentPaiementHistorySpecification extends AbstractHistorySpecification<InstrumentPaiementHistoryCriteria, InstrumentPaiementHistory> {

    public InstrumentPaiementHistorySpecification(InstrumentPaiementHistoryCriteria criteria) {
        super(criteria);
    }

    public InstrumentPaiementHistorySpecification(InstrumentPaiementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
