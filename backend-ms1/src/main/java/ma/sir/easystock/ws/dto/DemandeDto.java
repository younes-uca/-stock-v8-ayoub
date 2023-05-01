package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandeDto  extends AuditBaseDto {


    private ProduitDto produit ;
    private ClientDto client ;
    private LivraisonDto livraison ;
    private MagasinDto magasin ;
    private StoreDto store ;
    private EtatDemandeDto etatDemande ;

    private List<DemandeItemDto> demandeItems ;
    private List<PaiementDemandeDto> paiementDemandes ;


    public DemandeDto(){
        super();
    }




    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public LivraisonDto getLivraison(){
        return this.livraison;
    }

    public void setLivraison(LivraisonDto livraison){
        this.livraison = livraison;
    }
    public MagasinDto getMagasin(){
        return this.magasin;
    }

    public void setMagasin(MagasinDto magasin){
        this.magasin = magasin;
    }
    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }
    public EtatDemandeDto getEtatDemande(){
        return this.etatDemande;
    }

    public void setEtatDemande(EtatDemandeDto etatDemande){
        this.etatDemande = etatDemande;
    }



    public List<DemandeItemDto> getDemandeItems(){
        return this.demandeItems;
    }

    public void setDemandeItems(List<DemandeItemDto> demandeItems){
        this.demandeItems = demandeItems;
    }
    public List<PaiementDemandeDto> getPaiementDemandes(){
        return this.paiementDemandes;
    }

    public void setPaiementDemandes(List<PaiementDemandeDto> paiementDemandes){
        this.paiementDemandes = paiementDemandes;
    }

}
