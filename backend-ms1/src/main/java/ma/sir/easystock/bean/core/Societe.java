package ma.sir.easystock.bean.core;

import java.util.Objects;
import java.util.List;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "societe")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="societe_seq",sequenceName="societe_seq",allocationSize=1, initialValue = 1)
public class Societe   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ice;
    @Column(length = 500)
    private String siege;
    @Column(columnDefinition = "boolean default false")
    private Boolean bloqued = false;

    private Abonne abonne ;
    

    private List<Store> stores ;

    public Societe(){
        super();
    }

    public Societe(Long id,String ice){
        this.id = id;
        this.ice = ice ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="societe_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getSiege(){
        return this.siege;
    }
    public void setSiege(String siege){
        this.siege = siege;
    }
    public Boolean  getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }
    @OneToMany(mappedBy = "societe")
    public List<Store> getStores(){
        return this.stores;
    }
    public void setStores(List<Store> stores){
        this.stores = stores;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Abonne getAbonne(){
        return this.abonne;
    }
    public void setAbonne(Abonne abonne){
        this.abonne = abonne;
    }

    @Transient
    public String getLabel() {
        label = ice;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Societe societe = (Societe) o;
        return id != null && id.equals(societe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

