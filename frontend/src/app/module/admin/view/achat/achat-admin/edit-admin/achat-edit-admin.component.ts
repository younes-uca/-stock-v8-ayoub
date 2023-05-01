import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AchatService} from 'src/app/controller/service/Achat.service';
import {AchatDto} from 'src/app/controller/model/Achat.model';
import {AchatCriteria} from 'src/app/controller/criteria/AchatCriteria.model';


import {PaiementAchatDto} from 'src/app/controller/model/PaiementAchat.model';
import {PaiementAchatService} from 'src/app/controller/service/PaiementAchat.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {AvoirAchatDto} from 'src/app/controller/model/AvoirAchat.model';
import {AvoirAchatService} from 'src/app/controller/service/AvoirAchat.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/AvoirAchatItem.model';
import {AvoirAchatItemService} from 'src/app/controller/service/AvoirAchatItem.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {AchatItemDto} from 'src/app/controller/model/AchatItem.model';
import {AchatItemService} from 'src/app/controller/service/AchatItem.service';
import {FournisseurDto} from 'src/app/controller/model/Fournisseur.model';
import {FournisseurService} from 'src/app/controller/service/Fournisseur.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {EtatPaiementAchatDto} from 'src/app/controller/model/EtatPaiementAchat.model';
import {EtatPaiementAchatService} from 'src/app/controller/service/EtatPaiementAchat.service';

@Component({
  selector: 'app-achat-edit-admin',
  templateUrl: './achat-edit-admin.component.html'
})
export class AchatEditAdminComponent extends AbstractEditController<AchatDto, AchatCriteria, AchatService>   implements OnInit {

    private _paiementAchatsElement = new PaiementAchatDto();
    private _achatItemsElement = new AchatItemDto();
    private _avoirAchatsElement = new AvoirAchatDto();

    private _validAchatReference = true;

    private _validFournisseurIce = true;
    private _validFournisseurNom = true;
    private _validPaiementAchatsReference = true;
    private _validStoreLibelle = true;
    private _validStoreReference = true;



    constructor( private achatService: AchatService , private paiementAchatService: PaiementAchatService, private produitService: ProduitService, private avoirAchatService: AvoirAchatService, private instrumentPaiementService: InstrumentPaiementService, private modePaiementService: ModePaiementService, private achatItemService: AchatItemService, private fournisseurService: FournisseurService, private storeService: StoreService, private etatPaiementAchatService: EtatPaiementAchatService) {
        super(achatService);
    }

    ngOnInit(): void {
        this.paiementAchatsElement.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.paiementAchatsElement.instrumentPaiement = new InstrumentPaiementDto();
        this.instrumentPaiementService.findAll().subscribe((data) => this.instrumentPaiements = data);
        this.paiementAchatsElement.etatPaiementAchat = new EtatPaiementAchatDto();
        this.etatPaiementAchatService.findAll().subscribe((data) => this.etatPaiementAchats = data);

        this.achatItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);


    this.fournisseur = new FournisseurDto();
    this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
    this.store = new StoreDto();
    this.storeService.findAll().subscribe((data) => this.stores = data);
}
    public prepareEdit() {
        this.item.dateAchat = this.achatService.format(this.item.dateAchat);
    }



    public validatePaiementAchats(){
        this.errorMessages = new Array();
        this.validatePaiementAchatsReference();
    }
    public validateAchatItems(){
        this.errorMessages = new Array();
    }
    public validateAvoirAchats(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        this.validAchatReference = value;
        this.validPaiementAchatsReference = value;
        }
   public addPaiementAchats() {
        if( this.item.paiementAchats == null )
            this.item.paiementAchats = new Array<PaiementAchatDto>();
       this.validatePaiementAchats();
       if (this.errorMessages.length === 0) {
            if(this.paiementAchatsElement.id == null){
                this.item.paiementAchats.push(this.paiementAchatsElement);
            }else{
                const index = this.item.paiementAchats.findIndex(e => e.id == this.paiementAchatsElement.id);
                this.item.paiementAchats[index] = this.paiementAchatsElement;
            }
          this.paiementAchatsElement = new PaiementAchatDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deletePaiementAchat(p: PaiementAchatDto) {
        this.item.paiementAchats.forEach((element, index) => {
            if (element === p) { this.item.paiementAchats.splice(index, 1); }
        });
    }

    public editPaiementAchat(p: PaiementAchatDto) {
        this.paiementAchatsElement = {... p};
        this.activeTab = 0;
    }
   public addAchatItems() {
        if( this.item.achatItems == null )
            this.item.achatItems = new Array<AchatItemDto>();
       this.validateAchatItems();
       if (this.errorMessages.length === 0) {
            if(this.achatItemsElement.id == null){
                this.item.achatItems.push(this.achatItemsElement);
            }else{
                const index = this.item.achatItems.findIndex(e => e.id == this.achatItemsElement.id);
                this.item.achatItems[index] = this.achatItemsElement;
            }
          this.achatItemsElement = new AchatItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAchatItem(p: AchatItemDto) {
        this.item.achatItems.forEach((element, index) => {
            if (element === p) { this.item.achatItems.splice(index, 1); }
        });
    }

    public editAchatItem(p: AchatItemDto) {
        this.achatItemsElement = {... p};
        this.activeTab = 0;
    }
   public addAvoirAchats() {
        if( this.item.avoirAchats == null )
            this.item.avoirAchats = new Array<AvoirAchatDto>();
       this.validateAvoirAchats();
       if (this.errorMessages.length === 0) {
            if(this.avoirAchatsElement.id == null){
                this.item.avoirAchats.push(this.avoirAchatsElement);
            }else{
                const index = this.item.avoirAchats.findIndex(e => e.id == this.avoirAchatsElement.id);
                this.item.avoirAchats[index] = this.avoirAchatsElement;
            }
          this.avoirAchatsElement = new AvoirAchatDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirAchat(p: AvoirAchatDto) {
        this.item.avoirAchats.forEach((element, index) => {
            if (element === p) { this.item.avoirAchats.splice(index, 1); }
        });
    }

    public editAvoirAchat(p: AvoirAchatDto) {
        this.avoirAchatsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAchatReference();
    }
    public validateAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validAchatReference = false;
        } else {
            this.validAchatReference = true;
        }
    }


    private validatePaiementAchatsReference(){
        if (this.paiementAchatsElement.reference == null) {
        this.errorMessages.push('Reference de la paiementAchat est  invalide');
            this.validPaiementAchatsReference = false;
        } else {
            this.validPaiementAchatsReference = true;
        }
    }

   public async openCreateEtatPaiementAchat(etatPaiementAchat: string) {
        const isPermistted = await this.roleService.isPermitted('EtatPaiementAchat', 'edit');
        if(isPermistted) {
             this.etatPaiementAchat = new EtatPaiementAchatDto();
             this.createEtatPaiementAchatDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get etatPaiementAchat(): EtatPaiementAchatDto {
       return this.etatPaiementAchatService.item;
   }
  set etatPaiementAchat(value: EtatPaiementAchatDto) {
        this.etatPaiementAchatService.item = value;
   }
   get etatPaiementAchats(): Array<EtatPaiementAchatDto> {
        return this.etatPaiementAchatService.items;
   }
   set etatPaiementAchats(value: Array<EtatPaiementAchatDto>) {
        this.etatPaiementAchatService.items = value;
   }
   get createEtatPaiementAchatDialog(): boolean {
       return this.etatPaiementAchatService.createDialog;
   }
  set createEtatPaiementAchatDialog(value: boolean) {
       this.etatPaiementAchatService.createDialog= value;
   }
   get instrumentPaiement(): InstrumentPaiementDto {
       return this.instrumentPaiementService.item;
   }
  set instrumentPaiement(value: InstrumentPaiementDto) {
        this.instrumentPaiementService.item = value;
   }
   get instrumentPaiements(): Array<InstrumentPaiementDto> {
        return this.instrumentPaiementService.items;
   }
   set instrumentPaiements(value: Array<InstrumentPaiementDto>) {
        this.instrumentPaiementService.items = value;
   }
   get createInstrumentPaiementDialog(): boolean {
       return this.instrumentPaiementService.createDialog;
   }
  set createInstrumentPaiementDialog(value: boolean) {
       this.instrumentPaiementService.createDialog= value;
   }
   get store(): StoreDto {
       return this.storeService.item;
   }
  set store(value: StoreDto) {
        this.storeService.item = value;
   }
   get stores(): Array<StoreDto> {
        return this.storeService.items;
   }
   set stores(value: Array<StoreDto>) {
        this.storeService.items = value;
   }
   get createStoreDialog(): boolean {
       return this.storeService.createDialog;
   }
  set createStoreDialog(value: boolean) {
       this.storeService.createDialog= value;
   }
   get modePaiement(): ModePaiementDto {
       return this.modePaiementService.item;
   }
  set modePaiement(value: ModePaiementDto) {
        this.modePaiementService.item = value;
   }
   get modePaiements(): Array<ModePaiementDto> {
        return this.modePaiementService.items;
   }
   set modePaiements(value: Array<ModePaiementDto>) {
        this.modePaiementService.items = value;
   }
   get createModePaiementDialog(): boolean {
       return this.modePaiementService.createDialog;
   }
  set createModePaiementDialog(value: boolean) {
       this.modePaiementService.createDialog= value;
   }
   get fournisseur(): FournisseurDto {
       return this.fournisseurService.item;
   }
  set fournisseur(value: FournisseurDto) {
        this.fournisseurService.item = value;
   }
   get fournisseurs(): Array<FournisseurDto> {
        return this.fournisseurService.items;
   }
   set fournisseurs(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
   }
   get createFournisseurDialog(): boolean {
       return this.fournisseurService.createDialog;
   }
  set createFournisseurDialog(value: boolean) {
       this.fournisseurService.createDialog= value;
   }

    get paiementAchatsElement(): PaiementAchatDto {
        if( this._paiementAchatsElement == null )
            this._paiementAchatsElement = new PaiementAchatDto();
         return this._paiementAchatsElement;
    }

    set paiementAchatsElement(value: PaiementAchatDto) {
        this._paiementAchatsElement = value;
    }
    get achatItemsElement(): AchatItemDto {
        if( this._achatItemsElement == null )
            this._achatItemsElement = new AchatItemDto();
         return this._achatItemsElement;
    }

    set achatItemsElement(value: AchatItemDto) {
        this._achatItemsElement = value;
    }
    get avoirAchatsElement(): AvoirAchatDto {
        if( this._avoirAchatsElement == null )
            this._avoirAchatsElement = new AvoirAchatDto();
         return this._avoirAchatsElement;
    }

    set avoirAchatsElement(value: AvoirAchatDto) {
        this._avoirAchatsElement = value;
    }

    get validAchatReference(): boolean {
        return this._validAchatReference;
    }
    set validAchatReference(value: boolean) {
        this._validAchatReference = value;
    }

    get validFournisseurIce(): boolean {
        return this._validFournisseurIce;
    }
    set validFournisseurIce(value: boolean) {
        this._validFournisseurIce = value;
    }
    get validFournisseurNom(): boolean {
        return this._validFournisseurNom;
    }
    set validFournisseurNom(value: boolean) {
        this._validFournisseurNom = value;
    }
    get validPaiementAchatsReference(): boolean {
        return this._validPaiementAchatsReference;
    }
    set validPaiementAchatsReference(value: boolean) {
        this._validPaiementAchatsReference = value;
    }
    get validStoreLibelle(): boolean {
        return this._validStoreLibelle;
    }
    set validStoreLibelle(value: boolean) {
        this._validStoreLibelle = value;
    }
    get validStoreReference(): boolean {
        return this._validStoreReference;
    }
    set validStoreReference(value: boolean) {
        this._validStoreReference = value;
    }
}
