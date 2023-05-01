package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.PaiementDemandeCriteria;
import ma.sir.easystock.bean.core.PaiementDemande;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaiementDemandeSpecification extends  AbstractSpecification<PaiementDemandeCriteria, PaiementDemande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicate("dateEcheance", criteria.getDateEcheance(), criteria.getDateEcheanceFrom(), criteria.getDateEcheanceTo());
        addPredicate("referenceInstrumentPaiement", criteria.getReferenceInstrumentPaiement(),criteria.getReferenceInstrumentPaiementLike());
        addPredicate("dateDepose", criteria.getDateDepose(), criteria.getDateDeposeFrom(), criteria.getDateDeposeTo());
        addPredicate("photoChequeEffet", criteria.getPhotoChequeEffet(),criteria.getPhotoChequeEffetLike());
        addPredicateFk("demande","id", criteria.getDemande()==null?null:criteria.getDemande().getId());
        addPredicateFk("demande","id", criteria.getDemandes());
        addPredicateFk("modePaiement","id", criteria.getModePaiement()==null?null:criteria.getModePaiement().getId());
        addPredicateFk("modePaiement","id", criteria.getModePaiements());
        addPredicateFk("modePaiement","code", criteria.getModePaiement()==null?null:criteria.getModePaiement().getCode());
        addPredicateFk("instrumentPaiement","id", criteria.getInstrumentPaiement()==null?null:criteria.getInstrumentPaiement().getId());
        addPredicateFk("instrumentPaiement","id", criteria.getInstrumentPaiements());
        addPredicateFk("instrumentPaiement","code", criteria.getInstrumentPaiement()==null?null:criteria.getInstrumentPaiement().getCode());
        addPredicateFk("etatPaiementDemande","id", criteria.getEtatPaiementDemande()==null?null:criteria.getEtatPaiementDemande().getId());
        addPredicateFk("etatPaiementDemande","id", criteria.getEtatPaiementDemandes());
        addPredicateFk("etatPaiementDemande","code", criteria.getEtatPaiementDemande()==null?null:criteria.getEtatPaiementDemande().getCode());
    }

    public PaiementDemandeSpecification(PaiementDemandeCriteria criteria) {
        super(criteria);
    }

    public PaiementDemandeSpecification(PaiementDemandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
