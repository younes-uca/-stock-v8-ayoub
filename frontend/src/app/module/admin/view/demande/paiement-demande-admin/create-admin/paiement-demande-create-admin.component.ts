import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaiementDemandeService} from 'src/app/controller/service/PaiementDemande.service';
import {PaiementDemandeDto} from 'src/app/controller/model/PaiementDemande.model';
import {PaiementDemandeCriteria} from 'src/app/controller/criteria/PaiementDemandeCriteria.model';
import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {DemandeService} from 'src/app/controller/service/Demande.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {EtatPaiementDemandeDto} from 'src/app/controller/model/EtatPaiementDemande.model';
import {EtatPaiementDemandeService} from 'src/app/controller/service/EtatPaiementDemande.service';
@Component({
  selector: 'app-paiement-demande-create-admin',
  templateUrl: './paiement-demande-create-admin.component.html'
})
export class PaiementDemandeCreateAdminComponent extends AbstractCreateController<PaiementDemandeDto, PaiementDemandeCriteria, PaiementDemandeService>  implements OnInit {



   private _validPaiementDemandeReference = true;
    private _validModePaiementLibelle = true;
    private _validModePaiementCode = true;
    private _validInstrumentPaiementLibelle = true;
    private _validInstrumentPaiementCode = true;
    private _validEtatPaiementDemandeLibelle = true;
    private _validEtatPaiementDemandeCode = true;

    constructor( private paiementDemandeService: PaiementDemandeService , private demandeService: DemandeService, private instrumentPaiementService: InstrumentPaiementService, private modePaiementService: ModePaiementService, private etatPaiementDemandeService: EtatPaiementDemandeService) {
        super(paiementDemandeService);
    }

    ngOnInit(): void {
    this.demande = new DemandeDto();
    this.demandeService.findAll().subscribe((data) => this.demandes = data);
    this.modePaiement = new ModePaiementDto();
    this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
    this.instrumentPaiement = new InstrumentPaiementDto();
    this.instrumentPaiementService.findAll().subscribe((data) => this.instrumentPaiements = data);
    this.etatPaiementDemande = new EtatPaiementDemandeDto();
    this.etatPaiementDemandeService.findAll().subscribe((data) => this.etatPaiementDemandes = data);
}





    public setValidation(value: boolean){
        this.validPaiementDemandeReference = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementDemandeReference();
    }

    public validatePaiementDemandeReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validPaiementDemandeReference = false;
        } else {
            this.validPaiementDemandeReference = true;
        }
    }


    public async openCreateEtatPaiementDemande(etatPaiementDemande: string) {
    const isPermistted = await this.roleService.isPermitted('EtatPaiementDemande', 'add');
    if(isPermistted) {
         this.etatPaiementDemande = new EtatPaiementDemandeDto();
         this.createEtatPaiementDemandeDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateDemande(demande: string) {
    const isPermistted = await this.roleService.isPermitted('Demande', 'add');
    if(isPermistted) {
         this.demande = new DemandeDto();
         this.createDemandeDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get etatPaiementDemande(): EtatPaiementDemandeDto {
        return this.etatPaiementDemandeService.item;
    }
    set etatPaiementDemande(value: EtatPaiementDemandeDto) {
        this.etatPaiementDemandeService.item = value;
    }
    get etatPaiementDemandes(): Array<EtatPaiementDemandeDto> {
        return this.etatPaiementDemandeService.items;
    }
    set etatPaiementDemandes(value: Array<EtatPaiementDemandeDto>) {
        this.etatPaiementDemandeService.items = value;
    }
    get createEtatPaiementDemandeDialog(): boolean {
       return this.etatPaiementDemandeService.createDialog;
    }
    set createEtatPaiementDemandeDialog(value: boolean) {
        this.etatPaiementDemandeService.createDialog= value;
    }
    get demande(): DemandeDto {
        return this.demandeService.item;
    }
    set demande(value: DemandeDto) {
        this.demandeService.item = value;
    }
    get demandes(): Array<DemandeDto> {
        return this.demandeService.items;
    }
    set demandes(value: Array<DemandeDto>) {
        this.demandeService.items = value;
    }
    get createDemandeDialog(): boolean {
       return this.demandeService.createDialog;
    }
    set createDemandeDialog(value: boolean) {
        this.demandeService.createDialog= value;
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



    get validPaiementDemandeReference(): boolean {
        return this._validPaiementDemandeReference;
    }

    set validPaiementDemandeReference(value: boolean) {
         this._validPaiementDemandeReference = value;
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
    get validEtatPaiementDemandeLibelle(): boolean {
        return this._validEtatPaiementDemandeLibelle;
    }
    set validEtatPaiementDemandeLibelle(value: boolean) {
        this._validEtatPaiementDemandeLibelle = value;
    }
    get validEtatPaiementDemandeCode(): boolean {
        return this._validEtatPaiementDemandeCode;
    }
    set validEtatPaiementDemandeCode(value: boolean) {
        this._validEtatPaiementDemandeCode = value;
    }


}
