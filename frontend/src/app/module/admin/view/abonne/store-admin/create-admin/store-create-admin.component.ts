import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {StoreService} from 'src/app/controller/service/Store.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreCriteria} from 'src/app/controller/criteria/StoreCriteria.model';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {MagasinService} from 'src/app/controller/service/Magasin.service';
@Component({
  selector: 'app-store-create-admin',
  templateUrl: './store-create-admin.component.html'
})
export class StoreCreateAdminComponent extends AbstractCreateController<StoreDto, StoreCriteria, StoreService>  implements OnInit {

    private _magasinsElement = new MagasinDto();


   private _validStoreLibelle = true;
   private _validStoreReference = true;
    private _validSocieteIce = true;

    constructor( private storeService: StoreService , private societeService: SocieteService, private magasinService: MagasinService) {
        super(storeService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
}



    validateMagasins(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
        this.validStoreLibelle = value;
        this.validStoreReference = value;
    }

    public addMagasins() {
        if( this.item.magasins == null )
            this.item.magasins = new Array<MagasinDto>();
       this.validateMagasins();
       if (this.errorMessages.length === 0) {
              this.item.magasins.push({... this.magasinsElement});
              this.magasinsElement = new MagasinDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteMagasin(p: MagasinDto) {
        this.item.magasins.forEach((element, index) => {
            if (element === p) { this.item.magasins.splice(index, 1); }
        });
    }

    public editMagasin(p: MagasinDto) {
        this.magasinsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateStoreLibelle();
        this.validateStoreReference();
    }

    public validateStoreLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validStoreLibelle = false;
        } else {
            this.validStoreLibelle = true;
        }
    }
    public validateStoreReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validStoreReference = false;
        } else {
            this.validStoreReference = true;
        }
    }


    public async openCreateSociete(societe: string) {
    const isPermistted = await this.roleService.isPermitted('Societe', 'add');
    if(isPermistted) {
         this.societe = new SocieteDto();
         this.createSocieteDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get societe(): SocieteDto {
        return this.societeService.item;
    }
    set societe(value: SocieteDto) {
        this.societeService.item = value;
    }
    get societes(): Array<SocieteDto> {
        return this.societeService.items;
    }
    set societes(value: Array<SocieteDto>) {
        this.societeService.items = value;
    }
    get createSocieteDialog(): boolean {
       return this.societeService.createDialog;
    }
    set createSocieteDialog(value: boolean) {
        this.societeService.createDialog= value;
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

    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }

    get magasinsElement(): MagasinDto {
        if( this._magasinsElement == null )
            this._magasinsElement = new MagasinDto();
        return this._magasinsElement;
    }

    set magasinsElement(value: MagasinDto) {
        this._magasinsElement = value;
    }

}
