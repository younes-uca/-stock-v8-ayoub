package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;

import ma.sir.easystock.bean.core.Store;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.CommandeHistory;
import ma.sir.easystock.bean.core.Commande;
import ma.sir.easystock.ws.dto.CommandeDto;

@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeDto, CommandeHistory> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private ReceptionConverter receptionConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private EtatReceptionConverter etatReceptionConverter ;
    @Autowired
    private PaiementCommandeConverter paiementCommandeConverter ;
    @Autowired
    private EtatCommandeConverter etatCommandeConverter ;
    @Autowired
    private CommandeItemConverter commandeItemConverter ;
    @Autowired
    private ReceptionItemConverter receptionItemConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    private boolean client;
    private boolean store;
    private boolean etatCommande;
    private boolean paiementCommande;
    private boolean receptions;
    private boolean commandeItems;

    public  CommandeConverter(){
        super(Commande.class, CommandeDto.class, CommandeHistory.class);
        init(true);
    }

    @Override
    public Commande toItem(CommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Commande item = new Commande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateCommande()))
                item.setDateCommande(DateUtil.stringEnToDate(dto.getDateCommande()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalePaye()))
                item.setTotalePaye(dto.getTotalePaye());
            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(dto.getStore() != null && dto.getStore().getId() != null){
                item.setStore(new Store());
                item.getStore().setId(dto.getStore().getId());
            }

            if(this.etatCommande && dto.getEtatCommande()!=null)
                item.setEtatCommande(etatCommandeConverter.toItem(dto.getEtatCommande())) ;

            if(this.paiementCommande && dto.getPaiementCommande()!=null)
                item.setPaiementCommande(paiementCommandeConverter.toItem(dto.getPaiementCommande())) ;


            if(this.receptions && ListUtil.isNotEmpty(dto.getReceptions()))
                item.setReceptions(receptionConverter.toItem(dto.getReceptions()));
            if(this.commandeItems && ListUtil.isNotEmpty(dto.getCommandeItems()))
                item.setCommandeItems(commandeItemConverter.toItem(dto.getCommandeItems()));

        return item;
        }
    }

    @Override
    public CommandeDto toDto(Commande item) {
        if (item == null) {
            return null;
        } else {
            CommandeDto dto = new CommandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateCommande()!=null)
                dto.setDateCommande(DateUtil.dateTimeToString(item.getDateCommande()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalePaye()))
                dto.setTotalePaye(item.getTotalePaye());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }
        if(this.etatCommande && item.getEtatCommande()!=null) {
            dto.setEtatCommande(etatCommandeConverter.toDto(item.getEtatCommande())) ;
        }
        if(this.paiementCommande && item.getPaiementCommande()!=null) {
            paiementCommandeConverter.setCommande(false);
            dto.setPaiementCommande(paiementCommandeConverter.toDto(item.getPaiementCommande())) ;
            paiementCommandeConverter.setCommande(true);
        }
        if(this.receptions && ListUtil.isNotEmpty(item.getReceptions())){
            receptionConverter.init(true);
            receptionConverter.setCommande(false);
            dto.setReceptions(receptionConverter.toDto(item.getReceptions()));
            receptionConverter.setCommande(true);

        }
        if(this.commandeItems && ListUtil.isNotEmpty(item.getCommandeItems())){
            commandeItemConverter.init(true);
            commandeItemConverter.setCommande(false);
            dto.setCommandeItems(commandeItemConverter.toDto(item.getCommandeItems()));
            commandeItemConverter.setCommande(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.receptions = value;
        this.commandeItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
        this.store = value;
        this.etatCommande = value;
        this.paiementCommande = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public ReceptionConverter getReceptionConverter(){
        return this.receptionConverter;
    }
    public void setReceptionConverter(ReceptionConverter receptionConverter ){
        this.receptionConverter = receptionConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public EtatReceptionConverter getEtatReceptionConverter(){
        return this.etatReceptionConverter;
    }
    public void setEtatReceptionConverter(EtatReceptionConverter etatReceptionConverter ){
        this.etatReceptionConverter = etatReceptionConverter;
    }
    public PaiementCommandeConverter getPaiementCommandeConverter(){
        return this.paiementCommandeConverter;
    }
    public void setPaiementCommandeConverter(PaiementCommandeConverter paiementCommandeConverter ){
        this.paiementCommandeConverter = paiementCommandeConverter;
    }
    public EtatCommandeConverter getEtatCommandeConverter(){
        return this.etatCommandeConverter;
    }
    public void setEtatCommandeConverter(EtatCommandeConverter etatCommandeConverter ){
        this.etatCommandeConverter = etatCommandeConverter;
    }
    public CommandeItemConverter getCommandeItemConverter(){
        return this.commandeItemConverter;
    }
    public void setCommandeItemConverter(CommandeItemConverter commandeItemConverter ){
        this.commandeItemConverter = commandeItemConverter;
    }
    public ReceptionItemConverter getReceptionItemConverter(){
        return this.receptionItemConverter;
    }
    public void setReceptionItemConverter(ReceptionItemConverter receptionItemConverter ){
        this.receptionItemConverter = receptionItemConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
    public boolean  isEtatCommande(){
        return this.etatCommande;
    }
    public void  setEtatCommande(boolean etatCommande){
        this.etatCommande = etatCommande;
    }
    public boolean  isPaiementCommande(){
        return this.paiementCommande;
    }
    public void  setPaiementCommande(boolean paiementCommande){
        this.paiementCommande = paiementCommande;
    }
    public boolean  isReceptions(){
        return this.receptions ;
    }
    public void  setReceptions(boolean receptions ){
        this.receptions  = receptions ;
    }
    public boolean  isCommandeItems(){
        return this.commandeItems ;
    }
    public void  setCommandeItems(boolean commandeItems ){
        this.commandeItems  = commandeItems ;
    }
}
