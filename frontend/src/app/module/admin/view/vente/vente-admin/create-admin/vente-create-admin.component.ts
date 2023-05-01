import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {VenteService} from 'src/app/controller/service/Vente.service';
import {VenteDto} from 'src/app/controller/model/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/VenteCriteria.model';
import {PaiementVenteDto} from 'src/app/controller/model/PaiementVente.model';
import {PaiementVenteService} from 'src/app/controller/service/PaiementVente.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {EtatPaiementVenteDto} from 'src/app/controller/model/EtatPaiementVente.model';
import {EtatPaiementVenteService} from 'src/app/controller/service/EtatPaiementVente.service';
import {VenteItemDto} from 'src/app/controller/model/VenteItem.model';
import {VenteItemService} from 'src/app/controller/service/VenteItem.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
@Component({
  selector: 'app-vente-create-admin',
  templateUrl: './vente-create-admin.component.html'
})
export class VenteCreateAdminComponent extends AbstractCreateController<VenteDto, VenteCriteria, VenteService>  implements OnInit {

    private _paiementVentesElement = new PaiementVenteDto();
    private _venteItemsElement = new VenteItemDto();


   private _validVenteReference = true;
    private _validStoreLibelle = true;
    private _validStoreReference = true;
    private _validClientCin = true;
    private _validClientNom = true;
    private _validPaiementVentesReference = true;

    constructor( private venteService: VenteService , private paiementVenteService: PaiementVenteService, private etatPaiementVenteService: EtatPaiementVenteService, private produitService: ProduitService, private venteItemService: VenteItemService, private instrumentPaiementService: InstrumentPaiementService, private modePaiementService: ModePaiementService, private clientService: ClientService, private storeService: StoreService) {
        super(venteService);
    }

    ngOnInit(): void {
        this.paiementVentesElement.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.paiementVentesElement.instrumentPaiement = new InstrumentPaiementDto();
        this.instrumentPaiementService.findAll().subscribe((data) => this.instrumentPaiements = data);
        this.paiementVentesElement.etatPaiementVente = new EtatPaiementVenteDto();
        this.etatPaiementVenteService.findAll().subscribe((data) => this.etatPaiementVentes = data);
        this.venteItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
    this.store = new StoreDto();
    this.storeService.findAll().subscribe((data) => this.stores = data);
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
}



    validatePaiementVentes(){
        this.errorMessages = new Array();
        this.validatePaiementVentesReference();
    }
    validateVenteItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
        this.validVenteReference = value;
        this.validPaiementVentesReference = value;
    }

    public addPaiementVentes() {
        if( this.item.paiementVentes == null )
            this.item.paiementVentes = new Array<PaiementVenteDto>();
       this.validatePaiementVentes();
       if (this.errorMessages.length === 0) {
              this.item.paiementVentes.push({... this.paiementVentesElement});
              this.paiementVentesElement = new PaiementVenteDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletePaiementVente(p: PaiementVenteDto) {
        this.item.paiementVentes.forEach((element, index) => {
            if (element === p) { this.item.paiementVentes.splice(index, 1); }
        });
    }

    public editPaiementVente(p: PaiementVenteDto) {
        this.paiementVentesElement = {... p};
        this.activeTab = 0;
    }
    public addVenteItems() {
        if( this.item.venteItems == null )
            this.item.venteItems = new Array<VenteItemDto>();
       this.validateVenteItems();
       if (this.errorMessages.length === 0) {
              this.item.venteItems.push({... this.venteItemsElement});
              this.venteItemsElement = new VenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteVenteItem(p: VenteItemDto) {
        this.item.venteItems.forEach((element, index) => {
            if (element === p) { this.item.venteItems.splice(index, 1); }
        });
    }

    public editVenteItem(p: VenteItemDto) {
        this.venteItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateVenteReference();
    }

    public validateVenteReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validVenteReference = false;
        } else {
            this.validVenteReference = true;
        }
    }

    public validatePaiementVentesReference(){
        if (this.paiementVentesElement.reference == null) {
            this.errorMessages.push('Reference de la paiementVente est  invalide');
            this.validPaiementVentesReference = false;
        } else {
            this.validPaiementVentesReference = true;
        }
    }

    public async openCreateEtatPaiementVente(etatPaiementVente: string) {
    const isPermistted = await this.roleService.isPermitted('EtatPaiementVente', 'add');
    if(isPermistted) {
         this.etatPaiementVente = new EtatPaiementVenteDto();
         this.createEtatPaiementVenteDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateInstrumentPaiement(instrumentPaiement: string) {
    const isPermistted = await this.roleService.isPermitted('InstrumentPaiement', 'add');
    if(isPermistted) {
         this.instrumentPaiement = new InstrumentPaiementDto();
         this.createInstrumentPaiementDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get etatPaiementVente(): EtatPaiementVenteDto {
        return this.etatPaiementVenteService.item;
    }
    set etatPaiementVente(value: EtatPaiementVenteDto) {
        this.etatPaiementVenteService.item = value;
    }
    get etatPaiementVentes(): Array<EtatPaiementVenteDto> {
        return this.etatPaiementVenteService.items;
    }
    set etatPaiementVentes(value: Array<EtatPaiementVenteDto>) {
        this.etatPaiementVenteService.items = value;
    }
    get createEtatPaiementVenteDialog(): boolean {
       return this.etatPaiementVenteService.createDialog;
    }
    set createEtatPaiementVenteDialog(value: boolean) {
        this.etatPaiementVenteService.createDialog= value;
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
    get client(): ClientDto {
        return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients(): Array<ClientDto> {
        return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get createClientDialog(): boolean {
       return this.clientService.createDialog;
    }
    set createClientDialog(value: boolean) {
        this.clientService.createDialog= value;
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



    get validVenteReference(): boolean {
        return this._validVenteReference;
    }

    set validVenteReference(value: boolean) {
         this._validVenteReference = value;
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
    get validClientCin(): boolean {
        return this._validClientCin;
    }
    set validClientCin(value: boolean) {
        this._validClientCin = value;
    }
    get validClientNom(): boolean {
        return this._validClientNom;
    }
    set validClientNom(value: boolean) {
        this._validClientNom = value;
    }
    get validPaiementVentesReference(): boolean {
        return this._validPaiementVentesReference;
    }
    set validPaiementVentesReference(value: boolean) {
        this._validPaiementVentesReference = value;
    }

    get paiementVentesElement(): PaiementVenteDto {
        if( this._paiementVentesElement == null )
            this._paiementVentesElement = new PaiementVenteDto();
        return this._paiementVentesElement;
    }

    set paiementVentesElement(value: PaiementVenteDto) {
        this._paiementVentesElement = value;
    }
    get venteItemsElement(): VenteItemDto {
        if( this._venteItemsElement == null )
            this._venteItemsElement = new VenteItemDto();
        return this._venteItemsElement;
    }

    set venteItemsElement(value: VenteItemDto) {
        this._venteItemsElement = value;
    }

}
