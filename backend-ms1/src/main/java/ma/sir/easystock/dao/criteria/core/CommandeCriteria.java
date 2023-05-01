package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CommandeCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateCommande;
    private LocalDateTime dateCommandeFrom;
    private LocalDateTime dateCommandeTo;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalePaye;
    private String totalePayeMin;
    private String totalePayeMax;

    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private StoreCriteria store ;
    private List<StoreCriteria> stores ;
    private EtatCommandeCriteria etatCommande ;
    private List<EtatCommandeCriteria> etatCommandes ;
    private PaiementCommandeCriteria paiementCommande ;
    private List<PaiementCommandeCriteria> paiementCommandes ;


    public CommandeCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getDateCommande(){
        return this.dateCommande;
    }
    public void setDateCommande(LocalDateTime dateCommande){
        this.dateCommande = dateCommande;
    }
    public LocalDateTime getDateCommandeFrom(){
        return this.dateCommandeFrom;
    }
    public void setDateCommandeFrom(LocalDateTime dateCommandeFrom){
        this.dateCommandeFrom = dateCommandeFrom;
    }
    public LocalDateTime getDateCommandeTo(){
        return this.dateCommandeTo;
    }
    public void setDateCommandeTo(LocalDateTime dateCommandeTo){
        this.dateCommandeTo = dateCommandeTo;
    }
    public String getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        this.total = total;
    }   
    public String getTotalMin(){
        return this.totalMin;
    }
    public void setTotalMin(String totalMin){
        this.totalMin = totalMin;
    }
    public String getTotalMax(){
        return this.totalMax;
    }
    public void setTotalMax(String totalMax){
        this.totalMax = totalMax;
    }
      
    public String getTotalePaye(){
        return this.totalePaye;
    }
    public void setTotalePaye(String totalePaye){
        this.totalePaye = totalePaye;
    }   
    public String getTotalePayeMin(){
        return this.totalePayeMin;
    }
    public void setTotalePayeMin(String totalePayeMin){
        this.totalePayeMin = totalePayeMin;
    }
    public String getTotalePayeMax(){
        return this.totalePayeMax;
    }
    public void setTotalePayeMax(String totalePayeMax){
        this.totalePayeMax = totalePayeMax;
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
    public EtatCommandeCriteria getEtatCommande(){
        return this.etatCommande;
    }

    public void setEtatCommande(EtatCommandeCriteria etatCommande){
        this.etatCommande = etatCommande;
    }
    public List<EtatCommandeCriteria> getEtatCommandes(){
        return this.etatCommandes;
    }

    public void setEtatCommandes(List<EtatCommandeCriteria> etatCommandes){
        this.etatCommandes = etatCommandes;
    }
    public PaiementCommandeCriteria getPaiementCommande(){
        return this.paiementCommande;
    }

    public void setPaiementCommande(PaiementCommandeCriteria paiementCommande){
        this.paiementCommande = paiementCommande;
    }
    public List<PaiementCommandeCriteria> getPaiementCommandes(){
        return this.paiementCommandes;
    }

    public void setPaiementCommandes(List<PaiementCommandeCriteria> paiementCommandes){
        this.paiementCommandes = paiementCommandes;
    }
}
