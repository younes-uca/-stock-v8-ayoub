package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandeItemDto  extends AuditBaseDto {

    private BigDecimal prix  ;
    private BigDecimal quantite  ;

    private ProduitDto produit ;
    private DemandeDto demande ;



    public DemandeItemDto(){
        super();
    }



    @Log
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }

    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public DemandeDto getDemande(){
        return this.demande;
    }

    public void setDemande(DemandeDto demande){
        this.demande = demande;
    }




}
