import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaiementVenteService} from 'src/app/controller/service/PaiementVente.service';
import {PaiementVenteDto} from 'src/app/controller/model/PaiementVente.model';
import {PaiementVenteCriteria} from 'src/app/controller/criteria/PaiementVenteCriteria.model';


import {EtatPaiementVenteDto} from 'src/app/controller/model/EtatPaiementVente.model';
import {EtatPaiementVenteService} from 'src/app/controller/service/EtatPaiementVente.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {VenteDto} from 'src/app/controller/model/Vente.model';
import {VenteService} from 'src/app/controller/service/Vente.service';

@Component({
  selector: 'app-paiement-vente-edit-admin',
  templateUrl: './paiement-vente-edit-admin.component.html'
})
export class PaiementVenteEditAdminComponent extends AbstractEditController<PaiementVenteDto, PaiementVenteCriteria, PaiementVenteService>   implements OnInit {


    private _validPaiementVenteReference = true;

    private _validVenteReference = true;
    private _validModePaiementLibelle = true;
    private _validModePaiementCode = true;
    private _validInstrumentPaiementLibelle = true;
    private _validInstrumentPaiementCode = true;
    private _validEtatPaiementVenteLibelle = true;
    private _validEtatPaiementVenteCode = true;



    constructor( private paiementVenteService: PaiementVenteService , private etatPaiementVenteService: EtatPaiementVenteService, private instrumentPaiementService: InstrumentPaiementService, private modePaiementService: ModePaiementService, private venteService: VenteService) {
        super(paiementVenteService);
    }

    ngOnInit(): void {
    this.vente = new VenteDto();
    this.venteService.findAll().subscribe((data) => this.ventes = data);
    this.modePaiement = new ModePaiementDto();
    this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
    this.instrumentPaiement = new InstrumentPaiementDto();
    this.instrumentPaiementService.findAll().subscribe((data) => this.instrumentPaiements = data);
    this.etatPaiementVente = new EtatPaiementVenteDto();
    this.etatPaiementVenteService.findAll().subscribe((data) => this.etatPaiementVentes = data);
}
    public prepareEdit() {
        this.item.datePaiement = this.paiementVenteService.format(this.item.datePaiement);
        this.item.dateEcheance = this.paiementVenteService.format(this.item.dateEcheance);
        this.item.dateDepose = this.paiementVenteService.format(this.item.dateDepose);
    }



    public setValidation(value : boolean){
        this.validPaiementVenteReference = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementVenteReference();
    }
    public validatePaiementVenteReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validPaiementVenteReference = false;
        } else {
            this.validPaiementVenteReference = true;
        }
    }



   public async openCreateEtatPaiementVente(etatPaiementVente: string) {
        const isPermistted = await this.roleService.isPermitted('EtatPaiementVente', 'edit');
        if(isPermistted) {
             this.etatPaiementVente = new EtatPaiementVenteDto();
             this.createEtatPaiementVenteDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateVente(vente: string) {
        const isPermistted = await this.roleService.isPermitted('Vente', 'edit');
        if(isPermistted) {
             this.vente = new VenteDto();
             this.createVenteDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateInstrumentPaiement(instrumentPaiement: string) {
        const isPermistted = await this.roleService.isPermitted('InstrumentPaiement', 'edit');
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
   get vente(): VenteDto {
       return this.venteService.item;
   }
  set vente(value: VenteDto) {
        this.venteService.item = value;
   }
   get ventes(): Array<VenteDto> {
        return this.venteService.items;
   }
   set ventes(value: Array<VenteDto>) {
        this.venteService.items = value;
   }
   get createVenteDialog(): boolean {
       return this.venteService.createDialog;
   }
  set createVenteDialog(value: boolean) {
       this.venteService.createDialog= value;
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


    get validPaiementVenteReference(): boolean {
        return this._validPaiementVenteReference;
    }
    set validPaiementVenteReference(value: boolean) {
        this._validPaiementVenteReference = value;
    }

    get validVenteReference(): boolean {
        return this._validVenteReference;
    }
    set validVenteReference(value: boolean) {
        this._validVenteReference = value;
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
    get validEtatPaiementVenteLibelle(): boolean {
        return this._validEtatPaiementVenteLibelle;
    }
    set validEtatPaiementVenteLibelle(value: boolean) {
        this._validEtatPaiementVenteLibelle = value;
    }
    get validEtatPaiementVenteCode(): boolean {
        return this._validEtatPaiementVenteCode;
    }
    set validEtatPaiementVenteCode(value: boolean) {
        this._validEtatPaiementVenteCode = value;
    }
}
