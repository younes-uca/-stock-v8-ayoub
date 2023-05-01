package ma.sir.easystock.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "paiement_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_vente_seq",sequenceName="paiement_vente_seq",allocationSize=1, initialValue = 1)
public class PaiementVente   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime datePaiement ;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;
    private LocalDateTime dateEcheance ;
    @Column(length = 500)
    private String referenceInstrumentPaiement;
    private LocalDateTime dateDepose ;
    @Column(length = 500)
    private String photoChequeEffet;

    private Vente vente ;
    
    private ModePaiement modePaiement ;
    
    private InstrumentPaiement instrumentPaiement ;
    
    private EtatPaiementVente etatPaiementVente ;
    


    public PaiementVente(){
        super();
    }

    public PaiementVente(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_vente_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Vente getVente(){
        return this.vente;
    }
    public void setVente(Vente vente){
        this.vente = vente;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ModePaiement getModePaiement(){
        return this.modePaiement;
    }
    public void setModePaiement(ModePaiement modePaiement){
        this.modePaiement = modePaiement;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public LocalDateTime getDateEcheance(){
        return this.dateEcheance;
    }
    public void setDateEcheance(LocalDateTime dateEcheance){
        this.dateEcheance = dateEcheance;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public InstrumentPaiement getInstrumentPaiement(){
        return this.instrumentPaiement;
    }
    public void setInstrumentPaiement(InstrumentPaiement instrumentPaiement){
        this.instrumentPaiement = instrumentPaiement;
    }
    public String getReferenceInstrumentPaiement(){
        return this.referenceInstrumentPaiement;
    }
    public void setReferenceInstrumentPaiement(String referenceInstrumentPaiement){
        this.referenceInstrumentPaiement = referenceInstrumentPaiement;
    }
    public LocalDateTime getDateDepose(){
        return this.dateDepose;
    }
    public void setDateDepose(LocalDateTime dateDepose){
        this.dateDepose = dateDepose;
    }
    public String getPhotoChequeEffet(){
        return this.photoChequeEffet;
    }
    public void setPhotoChequeEffet(String photoChequeEffet){
        this.photoChequeEffet = photoChequeEffet;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatPaiementVente getEtatPaiementVente(){
        return this.etatPaiementVente;
    }
    public void setEtatPaiementVente(EtatPaiementVente etatPaiementVente){
        this.etatPaiementVente = etatPaiementVente;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementVente paiementVente = (PaiementVente) o;
        return id != null && id.equals(paiementVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

