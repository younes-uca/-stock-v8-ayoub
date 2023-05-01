import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ComptableTraitantService} from 'src/app/controller/service/ComptableTraitant.service';
import {ComptableTraitantDto} from 'src/app/controller/model/ComptableTraitant.model';
import {ComptableTraitantCriteria} from 'src/app/controller/criteria/ComptableTraitantCriteria.model';



@Component({
  selector: 'app-comptable-traitant-edit-admin',
  templateUrl: './comptable-traitant-edit-admin.component.html'
})
export class ComptableTraitantEditAdminComponent extends AbstractEditController<ComptableTraitantDto, ComptableTraitantCriteria, ComptableTraitantService>   implements OnInit {






    constructor( private comptableTraitantService: ComptableTraitantService ) {
        super(comptableTraitantService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}
