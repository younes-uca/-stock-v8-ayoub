package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaiementAchatCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime datePaiement;
    private LocalDateTime datePaiementFrom;
    private LocalDateTime datePaiementTo;
    private String montant;
    private String montantMin;
    private String montantMax;
    private String description;
    private String descriptionLike;
    private LocalDateTime dateEcheance;
    private LocalDateTime dateEcheanceFrom;
    private LocalDateTime dateEcheanceTo;
    private String referenceInstrumentPaiement;
    private String referenceInstrumentPaiementLike;
    private LocalDateTime dateDepose;
    private LocalDateTime dateDeposeFrom;
    private LocalDateTime dateDeposeTo;
    private String photoChequeEffet;
    private String photoChequeEffetLike;

    private AchatCriteria achat ;
    private List<AchatCriteria> achats ;
    private ModePaiementCriteria modePaiement ;
    private List<ModePaiementCriteria> modePaiements ;
    private InstrumentPaiementCriteria instrumentPaiement ;
    private List<InstrumentPaiementCriteria> instrumentPaiements ;
    private EtatPaiementAchatCriteria etatPaiementAchat ;
    private List<EtatPaiementAchatCriteria> etatPaiementAchats ;


    public PaiementAchatCriteria(){}

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

    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public LocalDateTime getDatePaiementFrom(){
        return this.datePaiementFrom;
    }
    public void setDatePaiementFrom(LocalDateTime datePaiementFrom){
        this.datePaiementFrom = datePaiementFrom;
    }
    public LocalDateTime getDatePaiementTo(){
        return this.datePaiementTo;
    }
    public void setDatePaiementTo(LocalDateTime datePaiementTo){
        this.datePaiementTo = datePaiementTo;
    }
    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public LocalDateTime getDateEcheance(){
        return this.dateEcheance;
    }
    public void setDateEcheance(LocalDateTime dateEcheance){
        this.dateEcheance = dateEcheance;
    }
    public LocalDateTime getDateEcheanceFrom(){
        return this.dateEcheanceFrom;
    }
    public void setDateEcheanceFrom(LocalDateTime dateEcheanceFrom){
        this.dateEcheanceFrom = dateEcheanceFrom;
    }
    public LocalDateTime getDateEcheanceTo(){
        return this.dateEcheanceTo;
    }
    public void setDateEcheanceTo(LocalDateTime dateEcheanceTo){
        this.dateEcheanceTo = dateEcheanceTo;
    }
    public String getReferenceInstrumentPaiement(){
        return this.referenceInstrumentPaiement;
    }
    public void setReferenceInstrumentPaiement(String referenceInstrumentPaiement){
        this.referenceInstrumentPaiement = referenceInstrumentPaiement;
    }
    public String getReferenceInstrumentPaiementLike(){
        return this.referenceInstrumentPaiementLike;
    }
    public void setReferenceInstrumentPaiementLike(String referenceInstrumentPaiementLike){
        this.referenceInstrumentPaiementLike = referenceInstrumentPaiementLike;
    }

    public LocalDateTime getDateDepose(){
        return this.dateDepose;
    }
    public void setDateDepose(LocalDateTime dateDepose){
        this.dateDepose = dateDepose;
    }
    public LocalDateTime getDateDeposeFrom(){
        return this.dateDeposeFrom;
    }
    public void setDateDeposeFrom(LocalDateTime dateDeposeFrom){
        this.dateDeposeFrom = dateDeposeFrom;
    }
    public LocalDateTime getDateDeposeTo(){
        return this.dateDeposeTo;
    }
    public void setDateDeposeTo(LocalDateTime dateDeposeTo){
        this.dateDeposeTo = dateDeposeTo;
    }
    public String getPhotoChequeEffet(){
        return this.photoChequeEffet;
    }
    public void setPhotoChequeEffet(String photoChequeEffet){
        this.photoChequeEffet = photoChequeEffet;
    }
    public String getPhotoChequeEffetLike(){
        return this.photoChequeEffetLike;
    }
    public void setPhotoChequeEffetLike(String photoChequeEffetLike){
        this.photoChequeEffetLike = photoChequeEffetLike;
    }


    public AchatCriteria getAchat(){
        return this.achat;
    }

    public void setAchat(AchatCriteria achat){
        this.achat = achat;
    }
    public List<AchatCriteria> getAchats(){
        return this.achats;
    }

    public void setAchats(List<AchatCriteria> achats){
        this.achats = achats;
    }
    public ModePaiementCriteria getModePaiement(){
        return this.modePaiement;
    }

    public void setModePaiement(ModePaiementCriteria modePaiement){
        this.modePaiement = modePaiement;
    }
    public List<ModePaiementCriteria> getModePaiements(){
        return this.modePaiements;
    }

    public void setModePaiements(List<ModePaiementCriteria> modePaiements){
        this.modePaiements = modePaiements;
    }
    public InstrumentPaiementCriteria getInstrumentPaiement(){
        return this.instrumentPaiement;
    }

    public void setInstrumentPaiement(InstrumentPaiementCriteria instrumentPaiement){
        this.instrumentPaiement = instrumentPaiement;
    }
    public List<InstrumentPaiementCriteria> getInstrumentPaiements(){
        return this.instrumentPaiements;
    }

    public void setInstrumentPaiements(List<InstrumentPaiementCriteria> instrumentPaiements){
        this.instrumentPaiements = instrumentPaiements;
    }
    public EtatPaiementAchatCriteria getEtatPaiementAchat(){
        return this.etatPaiementAchat;
    }

    public void setEtatPaiementAchat(EtatPaiementAchatCriteria etatPaiementAchat){
        this.etatPaiementAchat = etatPaiementAchat;
    }
    public List<EtatPaiementAchatCriteria> getEtatPaiementAchats(){
        return this.etatPaiementAchats;
    }

    public void setEtatPaiementAchats(List<EtatPaiementAchatCriteria> etatPaiementAchats){
        this.etatPaiementAchats = etatPaiementAchats;
    }
}
