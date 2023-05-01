package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Achat;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.PaiementAchatHistory;
import ma.sir.easystock.bean.core.PaiementAchat;
import ma.sir.easystock.ws.dto.PaiementAchatDto;

@Component
public class PaiementAchatConverter extends AbstractConverter<PaiementAchat, PaiementAchatDto, PaiementAchatHistory> {

    @Autowired
    private AchatConverter achatConverter ;
    @Autowired
    private InstrumentPaiementConverter instrumentPaiementConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    @Autowired
    private EtatPaiementAchatConverter etatPaiementAchatConverter ;
    private boolean achat;
    private boolean modePaiement;
    private boolean instrumentPaiement;
    private boolean etatPaiementAchat;

    public  PaiementAchatConverter(){
        super(PaiementAchat.class, PaiementAchatDto.class, PaiementAchatHistory.class);
    }

    @Override
    public PaiementAchat toItem(PaiementAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementAchat item = new PaiementAchat();
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
            if(dto.getAchat() != null && dto.getAchat().getId() != null){
                item.setAchat(new Achat());
                item.getAchat().setId(dto.getAchat().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;

            if(this.instrumentPaiement && dto.getInstrumentPaiement()!=null)
                item.setInstrumentPaiement(instrumentPaiementConverter.toItem(dto.getInstrumentPaiement())) ;

            if(this.etatPaiementAchat && dto.getEtatPaiementAchat()!=null)
                item.setEtatPaiementAchat(etatPaiementAchatConverter.toItem(dto.getEtatPaiementAchat())) ;



        return item;
        }
    }

    @Override
    public PaiementAchatDto toDto(PaiementAchat item) {
        if (item == null) {
            return null;
        } else {
            PaiementAchatDto dto = new PaiementAchatDto();
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
        if(this.achat && item.getAchat()!=null) {
            dto.setAchat(achatConverter.toDto(item.getAchat())) ;
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }
        if(this.instrumentPaiement && item.getInstrumentPaiement()!=null) {
            dto.setInstrumentPaiement(instrumentPaiementConverter.toDto(item.getInstrumentPaiement())) ;
        }
        if(this.etatPaiementAchat && item.getEtatPaiementAchat()!=null) {
            dto.setEtatPaiementAchat(etatPaiementAchatConverter.toDto(item.getEtatPaiementAchat())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.achat = value;
        this.modePaiement = value;
        this.instrumentPaiement = value;
        this.etatPaiementAchat = value;
    }


    public AchatConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatConverter(AchatConverter achatConverter ){
        this.achatConverter = achatConverter;
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
    public EtatPaiementAchatConverter getEtatPaiementAchatConverter(){
        return this.etatPaiementAchatConverter;
    }
    public void setEtatPaiementAchatConverter(EtatPaiementAchatConverter etatPaiementAchatConverter ){
        this.etatPaiementAchatConverter = etatPaiementAchatConverter;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
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
    public boolean  isEtatPaiementAchat(){
        return this.etatPaiementAchat;
    }
    public void  setEtatPaiementAchat(boolean etatPaiementAchat){
        this.etatPaiementAchat = etatPaiementAchat;
    }
}
