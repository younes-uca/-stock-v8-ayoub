package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.PaiementCommandeCriteria;
import ma.sir.easystock.bean.core.PaiementCommande;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaiementCommandeSpecification extends  AbstractSpecification<PaiementCommandeCriteria, PaiementCommande>  {

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
        addPredicateFk("commande","id", criteria.getCommande()==null?null:criteria.getCommande().getId());
        addPredicateFk("commande","id", criteria.getCommandes());
        addPredicateFk("commande","reference", criteria.getCommande()==null?null:criteria.getCommande().getReference());
        addPredicateFk("modePaiement","id", criteria.getModePaiement()==null?null:criteria.getModePaiement().getId());
        addPredicateFk("modePaiement","id", criteria.getModePaiements());
        addPredicateFk("modePaiement","code", criteria.getModePaiement()==null?null:criteria.getModePaiement().getCode());
        addPredicateFk("instrumentPaiement","id", criteria.getInstrumentPaiement()==null?null:criteria.getInstrumentPaiement().getId());
        addPredicateFk("instrumentPaiement","id", criteria.getInstrumentPaiements());
        addPredicateFk("instrumentPaiement","code", criteria.getInstrumentPaiement()==null?null:criteria.getInstrumentPaiement().getCode());
        addPredicateFk("etatPaiementCommande","id", criteria.getEtatPaiementCommande()==null?null:criteria.getEtatPaiementCommande().getId());
        addPredicateFk("etatPaiementCommande","id", criteria.getEtatPaiementCommandes());
        addPredicateFk("etatPaiementCommande","code", criteria.getEtatPaiementCommande()==null?null:criteria.getEtatPaiementCommande().getCode());
    }

    public PaiementCommandeSpecification(PaiementCommandeCriteria criteria) {
        super(criteria);
    }

    public PaiementCommandeSpecification(PaiementCommandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
