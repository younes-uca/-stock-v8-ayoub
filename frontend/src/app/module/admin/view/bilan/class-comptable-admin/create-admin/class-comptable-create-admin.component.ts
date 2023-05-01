import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ClassComptableService} from 'src/app/controller/service/ClassComptable.service';
import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';
import {ClassComptableCriteria} from 'src/app/controller/criteria/ClassComptableCriteria.model';
import {SousClassComptableDto} from 'src/app/controller/model/SousClassComptable.model';
import {SousClassComptableService} from 'src/app/controller/service/SousClassComptable.service';
import {CompteComptableDto} from 'src/app/controller/model/CompteComptable.model';
import {CompteComptableService} from 'src/app/controller/service/CompteComptable.service';
@Component({
  selector: 'app-class-comptable-create-admin',
  templateUrl: './class-comptable-create-admin.component.html'
})
export class ClassComptableCreateAdminComponent extends AbstractCreateController<ClassComptableDto, ClassComptableCriteria, ClassComptableService>  implements OnInit {

    private _sousClassComptablesElement = new SousClassComptableDto();


   private _validClassComptableLibelle = true;
   private _validClassComptableCode = true;
    private _validSousClassComptablesLibelle = true;
    private _validSousClassComptablesCode = true;

    constructor( private classComptableService: ClassComptableService , private sousClassComptableService: SousClassComptableService) {
        super(classComptableService);
    }

    ngOnInit(): void {
}



    validateSousClassComptables(){
        this.errorMessages = new Array();
        this.validateSousClassComptablesLibelle();
        this.validateSousClassComptablesCode();
    }


    public setValidation(value: boolean){
        this.validClassComptableLibelle = value;
        this.validClassComptableCode = value;
        this.validSousClassComptablesLibelle = value;
        this.validSousClassComptablesCode = value;
    }

    public addSousClassComptables() {
        if( this.item.sousClassComptables == null )
            this.item.sousClassComptables = new Array<SousClassComptableDto>();
       this.validateSousClassComptables();
       if (this.errorMessages.length === 0) {
              this.item.sousClassComptables.push({... this.sousClassComptablesElement});
              this.sousClassComptablesElement = new SousClassComptableDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteSousClassComptable(p: SousClassComptableDto) {
        this.item.sousClassComptables.forEach((element, index) => {
            if (element === p) { this.item.sousClassComptables.splice(index, 1); }
        });
    }

    public editSousClassComptable(p: SousClassComptableDto) {
        this.sousClassComptablesElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateClassComptableLibelle();
        this.validateClassComptableCode();
    }

    public validateClassComptableLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validClassComptableLibelle = false;
        } else {
            this.validClassComptableLibelle = true;
        }
    }
    public validateClassComptableCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validClassComptableCode = false;
        } else {
            this.validClassComptableCode = true;
        }
    }

    public validateSousClassComptablesLibelle(){
        if (this.sousClassComptablesElement.libelle == null) {
            this.errorMessages.push('Libelle de la sousClassComptable est  invalide');
            this.validSousClassComptablesLibelle = false;
        } else {
            this.validSousClassComptablesLibelle = true;
        }
    }
    public validateSousClassComptablesCode(){
        if (this.sousClassComptablesElement.code == null) {
            this.errorMessages.push('Code de la sousClassComptable est  invalide');
            this.validSousClassComptablesCode = false;
        } else {
            this.validSousClassComptablesCode = true;
        }
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

    get validSousClassComptablesLibelle(): boolean {
        return this._validSousClassComptablesLibelle;
    }
    set validSousClassComptablesLibelle(value: boolean) {
        this._validSousClassComptablesLibelle = value;
    }
    get validSousClassComptablesCode(): boolean {
        return this._validSousClassComptablesCode;
    }
    set validSousClassComptablesCode(value: boolean) {
        this._validSousClassComptablesCode = value;
    }

    get sousClassComptablesElement(): SousClassComptableDto {
        if( this._sousClassComptablesElement == null )
            this._sousClassComptablesElement = new SousClassComptableDto();
        return this._sousClassComptablesElement;
    }

    set sousClassComptablesElement(value: SousClassComptableDto) {
        this._sousClassComptablesElement = value;
    }

}
