package ma.sir.easystock.bean.core;

import java.util.Objects;
import java.util.List;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "demande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demande_seq",sequenceName="demande_seq",allocationSize=1, initialValue = 1)
public class Demande   extends AuditBusinessObject     {

    private Long id;


    private Produit produit ;
    
    private Client client ;
    
    private Livraison livraison ;
    
    private Magasin magasin ;
    
    private Store store ;
    
    private EtatDemande etatDemande ;
    

    private List<DemandeItem> demandeItems ;
    private List<PaiementDemande> paiementDemandes ;

    public Demande(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demande_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Livraison getLivraison(){
        return this.livraison;
    }
    public void setLivraison(Livraison livraison){
        this.livraison = livraison;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Magasin getMagasin(){
        return this.magasin;
    }
    public void setMagasin(Magasin magasin){
        this.magasin = magasin;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore(){
        return this.store;
    }
    public void setStore(Store store){
        this.store = store;
    }
    @OneToMany(mappedBy = "demande")
    public List<DemandeItem> getDemandeItems(){
        return this.demandeItems;
    }
    public void setDemandeItems(List<DemandeItem> demandeItems){
        this.demandeItems = demandeItems;
    }
    @OneToMany(mappedBy = "demande")
    public List<PaiementDemande> getPaiementDemandes(){
        return this.paiementDemandes;
    }
    public void setPaiementDemandes(List<PaiementDemande> paiementDemandes){
        this.paiementDemandes = paiementDemandes;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatDemande getEtatDemande(){
        return this.etatDemande;
    }
    public void setEtatDemande(EtatDemande etatDemande){
        this.etatDemande = etatDemande;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demande demande = (Demande) o;
        return id != null && id.equals(demande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

