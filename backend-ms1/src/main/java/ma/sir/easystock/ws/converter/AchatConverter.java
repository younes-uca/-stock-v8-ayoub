package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;

import ma.sir.easystock.bean.core.Store;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.AchatHistory;
import ma.sir.easystock.bean.core.Achat;
import ma.sir.easystock.ws.dto.AchatDto;

@Component
public class AchatConverter extends AbstractConverter<Achat, AchatDto, AchatHistory> {

    @Autowired
    private PaiementAchatConverter paiementAchatConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirAchatConverter avoirAchatConverter ;
    @Autowired
    private AvoirAchatItemConverter avoirAchatItemConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    @Autowired
    private AchatItemConverter achatItemConverter ;
    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private InstrumentPaiementConverter instrumentPaiementConverter ;
    @Autowired
    private EtatPaiementAchatConverter etatPaiementAchatConverter ;
    private boolean fournisseur;
    private boolean store;
    private boolean paiementAchats;
    private boolean achatItems;
    private boolean avoirAchats;

    public  AchatConverter(){
        super(Achat.class, AchatDto.class, AchatHistory.class);
        init(true);
    }

    @Override
    public Achat toItem(AchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        Achat item = new Achat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateAchat()))
                item.setDateAchat(DateUtil.stringEnToDate(dto.getDateAchat()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaye()))
                item.setTotalPaye(dto.getTotalPaye());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.fournisseur && dto.getFournisseur()!=null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(dto.getStore() != null && dto.getStore().getId() != null){
                item.setStore(new Store());
                item.getStore().setId(dto.getStore().getId());
            }


            if(this.paiementAchats && ListUtil.isNotEmpty(dto.getPaiementAchats()))
                item.setPaiementAchats(paiementAchatConverter.toItem(dto.getPaiementAchats()));
            if(this.achatItems && ListUtil.isNotEmpty(dto.getAchatItems()))
                item.setAchatItems(achatItemConverter.toItem(dto.getAchatItems()));
            if(this.avoirAchats && ListUtil.isNotEmpty(dto.getAvoirAchats()))
                item.setAvoirAchats(avoirAchatConverter.toItem(dto.getAvoirAchats()));

        return item;
        }
    }

    @Override
    public AchatDto toDto(Achat item) {
        if (item == null) {
            return null;
        } else {
            AchatDto dto = new AchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateAchat()!=null)
                dto.setDateAchat(DateUtil.dateTimeToString(item.getDateAchat()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaye()))
                dto.setTotalPaye(item.getTotalPaye());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }
        if(this.paiementAchats && ListUtil.isNotEmpty(item.getPaiementAchats())){
            paiementAchatConverter.init(true);
            paiementAchatConverter.setAchat(false);
            dto.setPaiementAchats(paiementAchatConverter.toDto(item.getPaiementAchats()));
            paiementAchatConverter.setAchat(true);

        }
        if(this.achatItems && ListUtil.isNotEmpty(item.getAchatItems())){
            achatItemConverter.init(true);
            achatItemConverter.setAchat(false);
            dto.setAchatItems(achatItemConverter.toDto(item.getAchatItems()));
            achatItemConverter.setAchat(true);

        }
        if(this.avoirAchats && ListUtil.isNotEmpty(item.getAvoirAchats())){
            avoirAchatConverter.init(true);
            avoirAchatConverter.setAchat(false);
            dto.setAvoirAchats(avoirAchatConverter.toDto(item.getAvoirAchats()));
            avoirAchatConverter.setAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.paiementAchats = value;
        this.achatItems = value;
        this.avoirAchats = value;
    }

    public void initObject(boolean value) {
        this.fournisseur = value;
        this.store = value;
    }


    public PaiementAchatConverter getPaiementAchatConverter(){
        return this.paiementAchatConverter;
    }
    public void setPaiementAchatConverter(PaiementAchatConverter paiementAchatConverter ){
        this.paiementAchatConverter = paiementAchatConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AvoirAchatConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatConverter(AvoirAchatConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public AvoirAchatItemConverter getAvoirAchatItemConverter(){
        return this.avoirAchatItemConverter;
    }
    public void setAvoirAchatItemConverter(AvoirAchatItemConverter avoirAchatItemConverter ){
        this.avoirAchatItemConverter = avoirAchatItemConverter;
    }
    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
    }
    public AchatItemConverter getAchatItemConverter(){
        return this.achatItemConverter;
    }
    public void setAchatItemConverter(AchatItemConverter achatItemConverter ){
        this.achatItemConverter = achatItemConverter;
    }
    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public InstrumentPaiementConverter getInstrumentPaiementConverter(){
        return this.instrumentPaiementConverter;
    }
    public void setInstrumentPaiementConverter(InstrumentPaiementConverter instrumentPaiementConverter ){
        this.instrumentPaiementConverter = instrumentPaiementConverter;
    }
    public EtatPaiementAchatConverter getEtatPaiementAchatConverter(){
        return this.etatPaiementAchatConverter;
    }
    public void setEtatPaiementAchatConverter(EtatPaiementAchatConverter etatPaiementAchatConverter ){
        this.etatPaiementAchatConverter = etatPaiementAchatConverter;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
    public boolean  isPaiementAchats(){
        return this.paiementAchats ;
    }
    public void  setPaiementAchats(boolean paiementAchats ){
        this.paiementAchats  = paiementAchats ;
    }
    public boolean  isAchatItems(){
        return this.achatItems ;
    }
    public void  setAchatItems(boolean achatItems ){
        this.achatItems  = achatItems ;
    }
    public boolean  isAvoirAchats(){
        return this.avoirAchats ;
    }
    public void  setAvoirAchats(boolean avoirAchats ){
        this.avoirAchats  = avoirAchats ;
    }
}
