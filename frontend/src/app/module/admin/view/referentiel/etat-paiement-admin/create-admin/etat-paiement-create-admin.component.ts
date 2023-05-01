import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatPaiementService} from 'src/app/controller/service/EtatPaiement.service';
import {EtatPaiementDto} from 'src/app/controller/model/EtatPaiement.model';
import {EtatPaiementCriteria} from 'src/app/controller/criteria/EtatPaiementCriteria.model';
@Component({
  selector: 'app-etat-paiement-create-admin',
  templateUrl: './etat-paiement-create-admin.component.html'
})
export class EtatPaiementCreateAdminComponent extends AbstractCreateController<EtatPaiementDto, EtatPaiementCriteria, EtatPaiementService>  implements OnInit {



   private _validEtatPaiementLibelle = true;
   private _validEtatPaiementCode = true;

    constructor( private etatPaiementService: EtatPaiementService ) {
        super(etatPaiementService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validEtatPaiementLibelle = value;
        this.validEtatPaiementCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatPaiementLibelle();
        this.validateEtatPaiementCode();
    }

    public validateEtatPaiementLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatPaiementLibelle = false;
        } else {
            this.validEtatPaiementLibelle = true;
        }
    }
    public validateEtatPaiementCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatPaiementCode = false;
        } else {
            this.validEtatPaiementCode = true;
        }
    }






    get validEtatPaiementLibelle(): boolean {
        return this._validEtatPaiementLibelle;
    }

    set validEtatPaiementLibelle(value: boolean) {
         this._validEtatPaiementLibelle = value;
    }
    get validEtatPaiementCode(): boolean {
        return this._validEtatPaiementCode;
    }

    set validEtatPaiementCode(value: boolean) {
         this._validEtatPaiementCode = value;
    }



}
