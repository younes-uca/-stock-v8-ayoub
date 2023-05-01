import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SousClassComptableService} from 'src/app/controller/service/SousClassComptable.service';
import {SousClassComptableDto} from 'src/app/controller/model/SousClassComptable.model';
import {SousClassComptableCriteria} from 'src/app/controller/criteria/SousClassComptableCriteria.model';
import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';
import {ClassComptableService} from 'src/app/controller/service/ClassComptable.service';
import {CompteComptableDto} from 'src/app/controller/model/CompteComptable.model';
import {CompteComptableService} from 'src/app/controller/service/CompteComptable.service';
@Component({
  selector: 'app-sous-class-comptable-create-admin',
  templateUrl: './sous-class-comptable-create-admin.component.html'
})
export class SousClassComptableCreateAdminComponent extends AbstractCreateController<SousClassComptableDto, SousClassComptableCriteria, SousClassComptableService>  implements OnInit {

    private _compteComptablesElement = new CompteComptableDto();


   private _validSousClassComptableLibelle = true;
   private _validSousClassComptableCode = true;
    private _validClassComptableLibelle = true;
    private _validClassComptableCode = true;
    private _validCompteComptablesLibelle = true;
    private _validCompteComptablesCode = true;

    constructor( private sousClassComptableService: SousClassComptableService , private classComptableService: ClassComptableService, private compteComptableService: CompteComptableService) {
        super(sousClassComptableService);
    }

    ngOnInit(): void {
    this.classComptable = new ClassComptableDto();
    this.classComptableService.findAll().subscribe((data) => this.classComptables = data);
}



    validateCompteComptables(){
        this.errorMessages = new Array();
        this.validateCompteComptablesLibelle();
        this.validateCompteComptablesCode();
    }


    public setValidation(value: boolean){
        this.validSousClassComptableLibelle = value;
        this.validSousClassComptableCode = value;
        this.validCompteComptablesLibelle = value;
        this.validCompteComptablesCode = value;
    }

    public addCompteComptables() {
        if( this.item.compteComptables == null )
            this.item.compteComptables = new Array<CompteComptableDto>();
       this.validateCompteComptables();
       if (this.errorMessages.length === 0) {
              this.item.compteComptables.push({... this.compteComptablesElement});
              this.compteComptablesElement = new CompteComptableDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteCompteComptable(p: CompteComptableDto) {
        this.item.compteComptables.forEach((element, index) => {
            if (element === p) { this.item.compteComptables.splice(index, 1); }
        });
    }

    public editCompteComptable(p: CompteComptableDto) {
        this.compteComptablesElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSousClassComptableLibelle();
        this.validateSousClassComptableCode();
    }

    public validateSousClassComptableLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validSousClassComptableLibelle = false;
        } else {
            this.validSousClassComptableLibelle = true;
        }
    }
    public validateSousClassComptableCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validSousClassComptableCode = false;
        } else {
            this.validSousClassComptableCode = true;
        }
    }

    public validateCompteComptablesLibelle(){
        if (this.compteComptablesElement.libelle == null) {
            this.errorMessages.push('Libelle de la compteComptable est  invalide');
            this.validCompteComptablesLibelle = false;
        } else {
            this.validCompteComptablesLibelle = true;
        }
    }
    public validateCompteComptablesCode(){
        if (this.compteComptablesElement.code == null) {
            this.errorMessages.push('Code de la compteComptable est  invalide');
            this.validCompteComptablesCode = false;
        } else {
            this.validCompteComptablesCode = true;
        }
    }

    public async openCreateClassComptable(classComptable: string) {
    const isPermistted = await this.roleService.isPermitted('ClassComptable', 'add');
    if(isPermistted) {
         this.classComptable = new ClassComptableDto();
         this.createClassComptableDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get classComptable(): ClassComptableDto {
        return this.classComptableService.item;
    }
    set classComptable(value: ClassComptableDto) {
        this.classComptableService.item = value;
    }
    get classComptables(): Array<ClassComptableDto> {
        return this.classComptableService.items;
    }
    set classComptables(value: Array<ClassComptableDto>) {
        this.classComptableService.items = value;
    }
    get createClassComptableDialog(): boolean {
       return this.classComptableService.createDialog;
    }
    set createClassComptableDialog(value: boolean) {
        this.classComptableService.createDialog= value;
    }



    get validSousClassComptableLibelle(): boolean {
        return this._validSousClassComptableLibelle;
    }

    set validSousClassComptableLibelle(value: boolean) {
         this._validSousClassComptableLibelle = value;
    }
    get validSousClassComptableCode(): boolean {
        return this._validSousClassComptableCode;
    }

    set validSousClassComptableCode(value: boolean) {
         this._validSousClassComptableCode = value;
    }

    get validClassComptableLibelle(): boolean {
        return this._validClassComptableLibelle;
    }
    set validClassComptableLibelle(value: boolean) {
        this._validClassComptableLibelle = value;
    }
    get validClassComptableCode(): boolean {
        return this._validClassComptableCode;
    }
    set validClassComptableCode(value: boolean) {
        this._validClassComptableCode = value;
    }
    get validCompteComptablesLibelle(): boolean {
        return this._validCompteComptablesLibelle;
    }
    set validCompteComptablesLibelle(value: boolean) {
        this._validCompteComptablesLibelle = value;
    }
    get validCompteComptablesCode(): boolean {
        return this._validCompteComptablesCode;
    }
    set validCompteComptablesCode(value: boolean) {
        this._validCompteComptablesCode = value;
    }

    get compteComptablesElement(): CompteComptableDto {
        if( this._compteComptablesElement == null )
            this._compteComptablesElement = new CompteComptableDto();
        return this._compteComptablesElement;
    }

    set compteComptablesElement(value: CompteComptableDto) {
        this._compteComptablesElement = value;
    }

}
