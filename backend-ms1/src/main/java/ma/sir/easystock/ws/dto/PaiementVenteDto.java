package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaiementVenteDto  extends AuditBaseDto {

    private String reference  ;
    private String datePaiement ;
    private BigDecimal montant  ;
    private String description  ;
    private String dateEcheance ;
    private String referenceInstrumentPaiement  ;
    private String dateDepose ;
    private String photoChequeEffet  ;

    private VenteDto vente ;
    private ModePaiementDto modePaiement ;
    private InstrumentPaiementDto instrumentPaiement ;
    private EtatPaiementVenteDto etatPaiementVente ;



    public PaiementVenteDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateEcheance(){
        return this.dateEcheance;
    }
    public void setDateEcheance(String dateEcheance){
        this.dateEcheance = dateEcheance;
    }

    @Log
    public String getReferenceInstrumentPaiement(){
        return this.referenceInstrumentPaiement;
    }
    public void setReferenceInstrumentPaiement(String referenceInstrumentPaiement){
        this.referenceInstrumentPaiement = referenceInstrumentPaiement;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDepose(){
        return this.dateDepose;
    }
    public void setDateDepose(String dateDepose){
        this.dateDepose = dateDepose;
    }

    @Log
    public String getPhotoChequeEffet(){
        return this.photoChequeEffet;
    }
    public void setPhotoChequeEffet(String photoChequeEffet){
        this.photoChequeEffet = photoChequeEffet;
    }


    public VenteDto getVente(){
        return this.vente;
    }

    public void setVente(VenteDto vente){
        this.vente = vente;
    }
    public ModePaiementDto getModePaiement(){
        return this.modePaiement;
    }

    public void setModePaiement(ModePaiementDto modePaiement){
        this.modePaiement = modePaiement;
    }
    public InstrumentPaiementDto getInstrumentPaiement(){
        return this.instrumentPaiement;
    }

    public void setInstrumentPaiement(InstrumentPaiementDto instrumentPaiement){
        this.instrumentPaiement = instrumentPaiement;
    }
    public EtatPaiementVenteDto getEtatPaiementVente(){
        return this.etatPaiementVente;
    }

    public void setEtatPaiementVente(EtatPaiementVenteDto etatPaiementVente){
        this.etatPaiementVente = etatPaiementVente;
    }




}
