package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatPaiementHistoryCriteria;
import ma.sir.easystock.bean.history.EtatPaiementHistory;


public class EtatPaiementHistorySpecification extends AbstractHistorySpecification<EtatPaiementHistoryCriteria, EtatPaiementHistory> {

    public EtatPaiementHistorySpecification(EtatPaiementHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatPaiementHistorySpecification(EtatPaiementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
