import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ComptableTraitantService} from 'src/app/controller/service/ComptableTraitant.service';
import {ComptableTraitantDto} from 'src/app/controller/model/ComptableTraitant.model';
import {ComptableTraitantCriteria} from 'src/app/controller/criteria/ComptableTraitantCriteria.model';
@Component({
  selector: 'app-comptable-traitant-create-admin',
  templateUrl: './comptable-traitant-create-admin.component.html'
})
export class ComptableTraitantCreateAdminComponent extends AbstractCreateController<ComptableTraitantDto, ComptableTraitantCriteria, ComptableTraitantService>  implements OnInit {




    constructor( private comptableTraitantService: ComptableTraitantService ) {
        super(comptableTraitantService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}
