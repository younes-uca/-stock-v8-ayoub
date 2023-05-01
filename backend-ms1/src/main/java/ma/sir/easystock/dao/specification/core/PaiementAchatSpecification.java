package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.PaiementAchatCriteria;
import ma.sir.easystock.bean.core.PaiementAchat;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaiementAchatSpecification extends  AbstractSpecification<PaiementAchatCriteria, PaiementAchat>  {

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
        addPredicateFk("achat","id", criteria.getAchat()==null?null:criteria.getAchat().getId());
        addPredicateFk("achat","id", criteria.getAchats());
        addPredicateFk("achat","reference", criteria.getAchat()==null?null:criteria.getAchat().getReference());
        addPredicateFk("modePaiement","id", criteria.getModePaiement()==null?null:criteria.getModePaiement().getId());
        addPredicateFk("modePaiement","id", criteria.getModePaiements());
        addPredicateFk("modePaiement","code", criteria.getModePaiement()==null?null:criteria.getModePaiement().getCode());
        addPredicateFk("instrumentPaiement","id", criteria.getInstrumentPaiement()==null?null:criteria.getInstrumentPaiement().getId());
        addPredicateFk("instrumentPaiement","id", criteria.getInstrumentPaiements());
        addPredicateFk("instrumentPaiement","code", criteria.getInstrumentPaiement()==null?null:criteria.getInstrumentPaiement().getCode());
        addPredicateFk("etatPaiementAchat","id", criteria.getEtatPaiementAchat()==null?null:criteria.getEtatPaiementAchat().getId());
        addPredicateFk("etatPaiementAchat","id", criteria.getEtatPaiementAchats());
        addPredicateFk("etatPaiementAchat","code", criteria.getEtatPaiementAchat()==null?null:criteria.getEtatPaiementAchat().getCode());
    }

    public PaiementAchatSpecification(PaiementAchatCriteria criteria) {
        super(criteria);
    }

    public PaiementAchatSpecification(PaiementAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
