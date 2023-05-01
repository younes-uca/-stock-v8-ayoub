import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaiementAchatService} from 'src/app/controller/service/PaiementAchat.service';
import {PaiementAchatDto} from 'src/app/controller/model/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/PaiementAchatCriteria.model';


import {AchatDto} from 'src/app/controller/model/Achat.model';
import {AchatService} from 'src/app/controller/service/Achat.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {EtatPaiementAchatDto} from 'src/app/controller/model/EtatPaiementAchat.model';
import {EtatPaiementAchatService} from 'src/app/controller/service/EtatPaiementAchat.service';

@Component({
  selector: 'app-paiement-achat-edit-admin',
  templateUrl: './paiement-achat-edit-admin.component.html'
})
export class PaiementAchatEditAdminComponent extends AbstractEditController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatService>   implements OnInit {


    private _validPaiementAchatReference = true;

    private _validAchatReference = true;
    private _validModePaiementLibelle = true;
    private _validModePaiementCode = true;
    private _validInstrumentPaiementLibelle = true;
    private _validInstrumentPaiementCode = true;
    private _validEtatPaiementAchatLibelle = true;
    private _validEtatPaiementAchatCode = true;



    constructor( private paiementAchatService: PaiementAchatService , private achatService: AchatService, private instrumentPaiementService: InstrumentPaiementService, private modePaiementService: ModePaiementService, private etatPaiementAchatService: EtatPaiementAchatService) {
        super(paiementAchatService);
    }

    ngOnInit(): void {
    this.achat = new AchatDto();
    this.achatService.findAll().subscribe((data) => this.achats = data);
    this.modePaiement = new ModePaiementDto();
    this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
    this.instrumentPaiement = new InstrumentPaiementDto();
    this.instrumentPaiementService.findAll().subscribe((data) => this.instrumentPaiements = data);
    this.etatPaiementAchat = new EtatPaiementAchatDto();
    this.etatPaiementAchatService.findAll().subscribe((data) => this.etatPaiementAchats = data);
}
    public prepareEdit() {
        this.item.datePaiement = this.paiementAchatService.format(this.item.datePaiement);
        this.item.dateEcheance = this.paiementAchatService.format(this.item.dateEcheance);
        this.item.dateDepose = this.paiementAchatService.format(this.item.dateDepose);
    }



    public setValidation(value : boolean){
        this.validPaiementAchatReference = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementAchatReference();
    }
    public validatePaiementAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validPaiementAchatReference = false;
        } else {
            this.validPaiementAchatReference = true;
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
   public async openCreateAchat(achat: string) {
        const isPermistted = await this.roleService.isPermitted('Achat', 'edit');
        if(isPermistted) {
             this.achat = new AchatDto();
             this.createAchatDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
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
   get achat(): AchatDto {
       return this.achatService.item;
   }
  set achat(value: AchatDto) {
        this.achatService.item = value;
   }
   get achats(): Array<AchatDto> {
        return this.achatService.items;
   }
   set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
   }
   get createAchatDialog(): boolean {
       return this.achatService.createDialog;
   }
  set createAchatDialog(value: boolean) {
       this.achatService.createDialog= value;
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


    get validPaiementAchatReference(): boolean {
        return this._validPaiementAchatReference;
    }
    set validPaiementAchatReference(value: boolean) {
        this._validPaiementAchatReference = value;
    }

    get validAchatReference(): boolean {
        return this._validAchatReference;
    }
    set validAchatReference(value: boolean) {
        this._validAchatReference = value;
    }
    get validModePaiementLibelle(): boolean {
        return this._validModePaiementLibelle;
    }
    set validModePaiementLibelle(value: boolean) {
        this._validModePaiementLibelle = value;
    }
    get validModePaiementCode(): boolean {
        return this._validModePaiementCode;
    }
    set validModePaiementCode(value: boolean) {
        this._validModePaiementCode = value;
    }
    get validInstrumentPaiementLibelle(): boolean {
        return this._validInstrumentPaiementLibelle;
    }
    set validInstrumentPaiementLibelle(value: boolean) {
        this._validInstrumentPaiementLibelle = value;
    }
    get validInstrumentPaiementCode(): boolean {
        return this._validInstrumentPaiementCode;
    }
    set validInstrumentPaiementCode(value: boolean) {
        this._validInstrumentPaiementCode = value;
    }
    get validEtatPaiementAchatLibelle(): boolean {
        return this._validEtatPaiementAchatLibelle;
    }
    set validEtatPaiementAchatLibelle(value: boolean) {
        this._validEtatPaiementAchatLibelle = value;
    }
    get validEtatPaiementAchatCode(): boolean {
        return this._validEtatPaiementAchatCode;
    }
    set validEtatPaiementAchatCode(value: boolean) {
        this._validEtatPaiementAchatCode = value;
    }
}
