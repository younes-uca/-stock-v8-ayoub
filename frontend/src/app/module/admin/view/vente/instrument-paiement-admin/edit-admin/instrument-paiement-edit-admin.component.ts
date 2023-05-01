import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementCriteria} from 'src/app/controller/criteria/InstrumentPaiementCriteria.model';



@Component({
  selector: 'app-instrument-paiement-edit-admin',
  templateUrl: './instrument-paiement-edit-admin.component.html'
})
export class InstrumentPaiementEditAdminComponent extends AbstractEditController<InstrumentPaiementDto, InstrumentPaiementCriteria, InstrumentPaiementService>   implements OnInit {


    private _validInstrumentPaiementLibelle = true;
    private _validInstrumentPaiementCode = true;




    constructor( private instrumentPaiementService: InstrumentPaiementService ) {
        super(instrumentPaiementService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validInstrumentPaiementLibelle = value;
        this.validInstrumentPaiementCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateInstrumentPaiementLibelle();
        this.validateInstrumentPaiementCode();
    }
    public validateInstrumentPaiementLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validInstrumentPaiementLibelle = false;
        } else {
            this.validInstrumentPaiementLibelle = true;
        }
    }
    public validateInstrumentPaiementCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validInstrumentPaiementCode = false;
        } else {
            this.validInstrumentPaiementCode = true;
        }
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

}
