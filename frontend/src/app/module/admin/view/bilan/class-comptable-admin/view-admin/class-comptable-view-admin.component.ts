import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ClassComptableService} from 'src/app/controller/service/ClassComptable.service';
import {ClassComptableDto} from 'src/app/controller/model/ClassComptable.model';
import {ClassComptableCriteria} from 'src/app/controller/criteria/ClassComptableCriteria.model';

import {SousClassComptableDto} from 'src/app/controller/model/SousClassComptable.model';
import {SousClassComptableService} from 'src/app/controller/service/SousClassComptable.service';
import {CompteComptableDto} from 'src/app/controller/model/CompteComptable.model';
import {CompteComptableService} from 'src/app/controller/service/CompteComptable.service';
@Component({
  selector: 'app-class-comptable-view-admin',
  templateUrl: './class-comptable-view-admin.component.html'
})
export class ClassComptableViewAdminComponent extends AbstractViewController<ClassComptableDto, ClassComptableCriteria, ClassComptableService> implements OnInit {

    sousClassComptables = new SousClassComptableDto();
    sousClassComptabless: Array<SousClassComptableDto> = [];

    constructor(private classComptableService: ClassComptableService, private sousClassComptableService: SousClassComptableService){
        super(classComptableService);
    }

    ngOnInit(): void {
    }




}
