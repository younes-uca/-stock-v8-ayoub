package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.CommandeCriteria;
import ma.sir.easystock.bean.core.Commande;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CommandeSpecification extends  AbstractSpecification<CommandeCriteria, Commande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateCommande", criteria.getDateCommande(), criteria.getDateCommandeFrom(), criteria.getDateCommandeTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateBigDecimal("totalePaye", criteria.getTotalePaye(), criteria.getTotalePayeMin(), criteria.getTotalePayeMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
        addPredicateFk("store","id", criteria.getStore()==null?null:criteria.getStore().getId());
        addPredicateFk("store","id", criteria.getStores());
        addPredicateFk("store","reference", criteria.getStore()==null?null:criteria.getStore().getReference());
        addPredicateFk("etatCommande","id", criteria.getEtatCommande()==null?null:criteria.getEtatCommande().getId());
        addPredicateFk("etatCommande","id", criteria.getEtatCommandes());
        addPredicateFk("etatCommande","code", criteria.getEtatCommande()==null?null:criteria.getEtatCommande().getCode());
        addPredicateFk("paiementCommande","id", criteria.getPaiementCommande()==null?null:criteria.getPaiementCommande().getId());
        addPredicateFk("paiementCommande","id", criteria.getPaiementCommandes());
        addPredicateFk("paiementCommande","reference", criteria.getPaiementCommande()==null?null:criteria.getPaiementCommande().getReference());
    }

    public CommandeSpecification(CommandeCriteria criteria) {
        super(criteria);
    }

    public CommandeSpecification(CommandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
