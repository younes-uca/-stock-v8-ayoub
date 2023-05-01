package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DemandeCriteria extends  BaseCriteria  {


    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private LivraisonCriteria livraison ;
    private List<LivraisonCriteria> livraisons ;
    private MagasinCriteria magasin ;
    private List<MagasinCriteria> magasins ;
    private StoreCriteria store ;
    private List<StoreCriteria> stores ;
    private EtatDemandeCriteria etatDemande ;
    private List<EtatDemandeCriteria> etatDemandes ;


    public DemandeCriteria(){}


    public ProduitCriteria getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitCriteria produit){
        this.produit = produit;
    }
    public List<ProduitCriteria> getProduits(){
        return this.produits;
    }

    public void setProduits(List<ProduitCriteria> produits){
        this.produits = produits;
    }
    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
    public LivraisonCriteria getLivraison(){
        return this.livraison;
    }

    public void setLivraison(LivraisonCriteria livraison){
        this.livraison = livraison;
    }
    public List<LivraisonCriteria> getLivraisons(){
        return this.livraisons;
    }

    public void setLivraisons(List<LivraisonCriteria> livraisons){
        this.livraisons = livraisons;
    }
    public MagasinCriteria getMagasin(){
        return this.magasin;
    }

    public void setMagasin(MagasinCriteria magasin){
        this.magasin = magasin;
    }
    public List<MagasinCriteria> getMagasins(){
        return this.magasins;
    }

    public void setMagasins(List<MagasinCriteria> magasins){
        this.magasins = magasins;
    }
    public StoreCriteria getStore(){
        return this.store;
    }

    public void setStore(StoreCriteria store){
        this.store = store;
    }
    public List<StoreCriteria> getStores(){
        return this.stores;
    }

    public void setStores(List<StoreCriteria> stores){
        this.stores = stores;
    }
    public EtatDemandeCriteria getEtatDemande(){
        return this.etatDemande;
    }

    public void setEtatDemande(EtatDemandeCriteria etatDemande){
        this.etatDemande = etatDemande;
    }
    public List<EtatDemandeCriteria> getEtatDemandes(){
        return this.etatDemandes;
    }

    public void setEtatDemandes(List<EtatDemandeCriteria> etatDemandes){
        this.etatDemandes = etatDemandes;
    }
}
