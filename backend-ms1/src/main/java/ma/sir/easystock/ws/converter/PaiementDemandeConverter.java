package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Demande;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.PaiementDemandeHistory;
import ma.sir.easystock.bean.core.PaiementDemande;
import ma.sir.easystock.ws.dto.PaiementDemandeDto;

@Component
public class PaiementDemandeConverter extends AbstractConverter<PaiementDemande, PaiementDemandeDto, PaiementDemandeHistory> {

    @Autowired
    private DemandeConverter demandeConverter ;
    @Autowired
    private InstrumentPaiementConverter instrumentPaiementConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    @Autowired
    private EtatPaiementDemandeConverter etatPaiementDemandeConverter ;
    private boolean demande;
    private boolean modePaiement;
    private boolean instrumentPaiement;
    private boolean etatPaiementDemande;

    public  PaiementDemandeConverter(){
        super(PaiementDemande.class, PaiementDemandeDto.class, PaiementDemandeHistory.class);
    }

    @Override
    public PaiementDemande toItem(PaiementDemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementDemande item = new PaiementDemande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getDateEcheance()))
                item.setDateEcheance(DateUtil.stringEnToDate(dto.getDateEcheance()));
            if(StringUtil.isNotEmpty(dto.getReferenceInstrumentPaiement()))
                item.setReferenceInstrumentPaiement(dto.getReferenceInstrumentPaiement());
            if(StringUtil.isNotEmpty(dto.getDateDepose()))
                item.setDateDepose(DateUtil.stringEnToDate(dto.getDateDepose()));
            if(StringUtil.isNotEmpty(dto.getPhotoChequeEffet()))
                item.setPhotoChequeEffet(dto.getPhotoChequeEffet());
            if(dto.getDemande() != null && dto.getDemande().getId() != null){
                item.setDemande(new Demande());
                item.getDemande().setId(dto.getDemande().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;

            if(this.instrumentPaiement && dto.getInstrumentPaiement()!=null)
                item.setInstrumentPaiement(instrumentPaiementConverter.toItem(dto.getInstrumentPaiement())) ;

            if(this.etatPaiementDemande && dto.getEtatPaiementDemande()!=null)
                item.setEtatPaiementDemande(etatPaiementDemandeConverter.toItem(dto.getEtatPaiementDemande())) ;



        return item;
        }
    }

    @Override
    public PaiementDemandeDto toDto(PaiementDemande item) {
        if (item == null) {
            return null;
        } else {
            PaiementDemandeDto dto = new PaiementDemandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(item.getDateEcheance()!=null)
                dto.setDateEcheance(DateUtil.dateTimeToString(item.getDateEcheance()));
            if(StringUtil.isNotEmpty(item.getReferenceInstrumentPaiement()))
                dto.setReferenceInstrumentPaiement(item.getReferenceInstrumentPaiement());
            if(item.getDateDepose()!=null)
                dto.setDateDepose(DateUtil.dateTimeToString(item.getDateDepose()));
            if(StringUtil.isNotEmpty(item.getPhotoChequeEffet()))
                dto.setPhotoChequeEffet(item.getPhotoChequeEffet());
        if(this.demande && item.getDemande()!=null) {
            dto.setDemande(demandeConverter.toDto(item.getDemande())) ;
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }
        if(this.instrumentPaiement && item.getInstrumentPaiement()!=null) {
            dto.setInstrumentPaiement(instrumentPaiementConverter.toDto(item.getInstrumentPaiement())) ;
        }
        if(this.etatPaiementDemande && item.getEtatPaiementDemande()!=null) {
            dto.setEtatPaiementDemande(etatPaiementDemandeConverter.toDto(item.getEtatPaiementDemande())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.demande = value;
        this.modePaiement = value;
        this.instrumentPaiement = value;
        this.etatPaiementDemande = value;
    }


    public DemandeConverter getDemandeConverter(){
        return this.demandeConverter;
    }
    public void setDemandeConverter(DemandeConverter demandeConverter ){
        this.demandeConverter = demandeConverter;
    }
    public InstrumentPaiementConverter getInstrumentPaiementConverter(){
        return this.instrumentPaiementConverter;
    }
    public void setInstrumentPaiementConverter(InstrumentPaiementConverter instrumentPaiementConverter ){
        this.instrumentPaiementConverter = instrumentPaiementConverter;
    }
    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
    }
    public EtatPaiementDemandeConverter getEtatPaiementDemandeConverter(){
        return this.etatPaiementDemandeConverter;
    }
    public void setEtatPaiementDemandeConverter(EtatPaiementDemandeConverter etatPaiementDemandeConverter ){
        this.etatPaiementDemandeConverter = etatPaiementDemandeConverter;
    }
    public boolean  isDemande(){
        return this.demande;
    }
    public void  setDemande(boolean demande){
        this.demande = demande;
    }
    public boolean  isModePaiement(){
        return this.modePaiement;
    }
    public void  setModePaiement(boolean modePaiement){
        this.modePaiement = modePaiement;
    }
    public boolean  isInstrumentPaiement(){
        return this.instrumentPaiement;
    }
    public void  setInstrumentPaiement(boolean instrumentPaiement){
        this.instrumentPaiement = instrumentPaiement;
    }
    public boolean  isEtatPaiementDemande(){
        return this.etatPaiementDemande;
    }
    public void  setEtatPaiementDemande(boolean etatPaiementDemande){
        this.etatPaiementDemande = etatPaiementDemande;
    }
}
