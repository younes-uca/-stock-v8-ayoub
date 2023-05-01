package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;

import ma.sir.easystock.bean.core.Produit;
import ma.sir.easystock.bean.core.Livraison;
import ma.sir.easystock.bean.core.Store;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.DemandeHistory;
import ma.sir.easystock.bean.core.Demande;
import ma.sir.easystock.ws.dto.DemandeDto;

@Component
public class DemandeConverter extends AbstractConverter<Demande, DemandeDto, DemandeHistory> {

    @Autowired
    private EtatDemandeConverter etatDemandeConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private DemandeItemConverter demandeItemConverter ;
    @Autowired
    private LivraisonConverter livraisonConverter ;
    @Autowired
    private InstrumentPaiementConverter instrumentPaiementConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private EtatPaiementDemandeConverter etatPaiementDemandeConverter ;
    @Autowired
    private PaiementDemandeConverter paiementDemandeConverter ;
    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    @Autowired
    private MagasinConverter magasinConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    private boolean produit;
    private boolean client;
    private boolean livraison;
    private boolean magasin;
    private boolean store;
    private boolean etatDemande;
    private boolean demandeItems;
    private boolean paiementDemandes;

    public  DemandeConverter(){
        super(Demande.class, DemandeDto.class, DemandeHistory.class);
        init(true);
    }

    @Override
    public Demande toItem(DemandeDto dto) {
        if (dto == null) {
            return null;
        } else {
        Demande item = new Demande();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
            }

            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(dto.getLivraison() != null && dto.getLivraison().getId() != null){
                item.setLivraison(new Livraison());
                item.getLivraison().setId(dto.getLivraison().getId());
            }

            if(this.magasin && dto.getMagasin()!=null)
                item.setMagasin(magasinConverter.toItem(dto.getMagasin())) ;

            if(dto.getStore() != null && dto.getStore().getId() != null){
                item.setStore(new Store());
                item.getStore().setId(dto.getStore().getId());
            }

            if(this.etatDemande && dto.getEtatDemande()!=null)
                item.setEtatDemande(etatDemandeConverter.toItem(dto.getEtatDemande())) ;


            if(this.demandeItems && ListUtil.isNotEmpty(dto.getDemandeItems()))
                item.setDemandeItems(demandeItemConverter.toItem(dto.getDemandeItems()));
            if(this.paiementDemandes && ListUtil.isNotEmpty(dto.getPaiementDemandes()))
                item.setPaiementDemandes(paiementDemandeConverter.toItem(dto.getPaiementDemandes()));

        return item;
        }
    }

    @Override
    public DemandeDto toDto(Demande item) {
        if (item == null) {
            return null;
        } else {
            DemandeDto dto = new DemandeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.livraison && item.getLivraison()!=null) {
            livraisonConverter.setDemande(false);
            dto.setLivraison(livraisonConverter.toDto(item.getLivraison())) ;
            livraisonConverter.setDemande(true);
        }
        if(this.magasin && item.getMagasin()!=null) {
            dto.setMagasin(magasinConverter.toDto(item.getMagasin())) ;
        }
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }
        if(this.etatDemande && item.getEtatDemande()!=null) {
            dto.setEtatDemande(etatDemandeConverter.toDto(item.getEtatDemande())) ;
        }
        if(this.demandeItems && ListUtil.isNotEmpty(item.getDemandeItems())){
            demandeItemConverter.init(true);
            demandeItemConverter.setDemande(false);
            dto.setDemandeItems(demandeItemConverter.toDto(item.getDemandeItems()));
            demandeItemConverter.setDemande(true);

        }
        if(this.paiementDemandes && ListUtil.isNotEmpty(item.getPaiementDemandes())){
            paiementDemandeConverter.init(true);
            paiementDemandeConverter.setDemande(false);
            dto.setPaiementDemandes(paiementDemandeConverter.toDto(item.getPaiementDemandes()));
            paiementDemandeConverter.setDemande(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.demandeItems = value;
        this.paiementDemandes = value;
    }

    public void initObject(boolean value) {
        this.produit = value;
        this.client = value;
        this.livraison = value;
        this.magasin = value;
        this.store = value;
        this.etatDemande = value;
    }


    public EtatDemandeConverter getEtatDemandeConverter(){
        return this.etatDemandeConverter;
    }
    public void setEtatDemandeConverter(EtatDemandeConverter etatDemandeConverter ){
        this.etatDemandeConverter = etatDemandeConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public DemandeItemConverter getDemandeItemConverter(){
        return this.demandeItemConverter;
    }
    public void setDemandeItemConverter(DemandeItemConverter demandeItemConverter ){
        this.demandeItemConverter = demandeItemConverter;
    }
    public LivraisonConverter getLivraisonConverter(){
        return this.livraisonConverter;
    }
    public void setLivraisonConverter(LivraisonConverter livraisonConverter ){
        this.livraisonConverter = livraisonConverter;
    }
    public InstrumentPaiementConverter getInstrumentPaiementConverter(){
        return this.instrumentPaiementConverter;
    }
    public void setInstrumentPaiementConverter(InstrumentPaiementConverter instrumentPaiementConverter ){
        this.instrumentPaiementConverter = instrumentPaiementConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public EtatPaiementDemandeConverter getEtatPaiementDemandeConverter(){
        return this.etatPaiementDemandeConverter;
    }
    public void setEtatPaiementDemandeConverter(EtatPaiementDemandeConverter etatPaiementDemandeConverter ){
        this.etatPaiementDemandeConverter = etatPaiementDemandeConverter;
    }
    public PaiementDemandeConverter getPaiementDemandeConverter(){
        return this.paiementDemandeConverter;
    }
    public void setPaiementDemandeConverter(PaiementDemandeConverter paiementDemandeConverter ){
        this.paiementDemandeConverter = paiementDemandeConverter;
    }
    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
    }
    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isLivraison(){
        return this.livraison;
    }
    public void  setLivraison(boolean livraison){
        this.livraison = livraison;
    }
    public boolean  isMagasin(){
        return this.magasin;
    }
    public void  setMagasin(boolean magasin){
        this.magasin = magasin;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
    public boolean  isEtatDemande(){
        return this.etatDemande;
    }
    public void  setEtatDemande(boolean etatDemande){
        this.etatDemande = etatDemande;
    }
    public boolean  isDemandeItems(){
        return this.demandeItems ;
    }
    public void  setDemandeItems(boolean demandeItems ){
        this.demandeItems  = demandeItems ;
    }
    public boolean  isPaiementDemandes(){
        return this.paiementDemandes ;
    }
    public void  setPaiementDemandes(boolean paiementDemandes ){
        this.paiementDemandes  = paiementDemandes ;
    }
}
