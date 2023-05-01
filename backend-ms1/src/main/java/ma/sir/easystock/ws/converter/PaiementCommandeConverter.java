package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.easystock.bean.core.Commande;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.PaiementCommandeHistory;
import ma.sir.easystock.bean.core.PaiementCommande;
import ma.sir.easystock.ws.dto.PaiementCommandeDto;

@Component
public class PaiementCommandeConverter extends AbstractConverter<PaiementCommande, PaiementCommandeDto, PaiementCommandeHistory> {

    @Autowired
    private EtatPaiementCommandeConverter etatPaiementCommandeConverter ;
    @Autowired
    private CommandeConverter commandeConverter ;
    @Autowired
    private InstrumentPaiementConverter instrumentPaiementConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    private boolean commande;
    private boolean modePaiement;
    private boolean instrumentPaiement;
    private boolean etatPaiementCommande;

    public  PaiementCommandeConverter(){
        super(PaiementCommande.class, PaiementCommandeDto.class, PaiementCommandeHistory.class);
    }

    @Override
    public PaiementCommande toItem(PaiementCommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementCommande item = new PaiementCommande();
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
            if(dto.getCommande() != null && dto.getCommande().getId() != null){
                item.setCommande(new Commande());
                item.getCommande().setId(dto.getCommande().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;

            if(this.instrumentPaiement && dto.getInstrumentPaiement()!=null)
                item.setInstrumentPaiement(instrumentPaiementConverter.toItem(dto.getInstrumentPaiement())) ;

            if(this.etatPaiementCommande && dto.getEtatPaiementCommande()!=null)
                item.setEtatPaiementCommande(etatPaiementCommandeConverter.toItem(dto.getEtatPaiementCommande())) ;



        return item;
        }
    }

    @Override
    public PaiementCommandeDto toDto(PaiementCommande item) {
        if (item == null) {
            return null;
        } else {
            PaiementCommandeDto dto = new PaiementCommandeDto();
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
        if(this.commande && item.getCommande()!=null) {
            commandeConverter.setPaiementCommande(false);
            dto.setCommande(commandeConverter.toDto(item.getCommande())) ;
            commandeConverter.setPaiementCommande(true);
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }
        if(this.instrumentPaiement && item.getInstrumentPaiement()!=null) {
            dto.setInstrumentPaiement(instrumentPaiementConverter.toDto(item.getInstrumentPaiement())) ;
        }
        if(this.etatPaiementCommande && item.getEtatPaiementCommande()!=null) {
            dto.setEtatPaiementCommande(etatPaiementCommandeConverter.toDto(item.getEtatPaiementCommande())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.commande = value;
        this.modePaiement = value;
        this.instrumentPaiement = value;
        this.etatPaiementCommande = value;
    }


    public EtatPaiementCommandeConverter getEtatPaiementCommandeConverter(){
        return this.etatPaiementCommandeConverter;
    }
    public void setEtatPaiementCommandeConverter(EtatPaiementCommandeConverter etatPaiementCommandeConverter ){
        this.etatPaiementCommandeConverter = etatPaiementCommandeConverter;
    }
    public CommandeConverter getCommandeConverter(){
        return this.commandeConverter;
    }
    public void setCommandeConverter(CommandeConverter commandeConverter ){
        this.commandeConverter = commandeConverter;
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
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
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
    public boolean  isEtatPaiementCommande(){
        return this.etatPaiementCommande;
    }
    public void  setEtatPaiementCommande(boolean etatPaiementCommande){
        this.etatPaiementCommande = etatPaiementCommande;
    }
}
