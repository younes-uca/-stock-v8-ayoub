import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SocieteService} from 'src/app/controller/service/Societe.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteCriteria} from 'src/app/controller/criteria/SocieteCriteria.model';

import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {MagasinService} from 'src/app/controller/service/Magasin.service';
import {AbonneDto} from 'src/app/controller/model/Abonne.model';
import {AbonneService} from 'src/app/controller/service/Abonne.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
@Component({
  selector: 'app-societe-view-admin',
  templateUrl: './societe-view-admin.component.html'
})
export class SocieteViewAdminComponent extends AbstractViewController<SocieteDto, SocieteCriteria, SocieteService> implements OnInit {

    stores = new StoreDto();
    storess: Array<StoreDto> = [];

    constructor(private societeService: SocieteService, private abonneService: AbonneService, private storeService: StoreService){
        super(societeService);
    }

    ngOnInit(): void {
        this.abonne = new AbonneDto();
        this.abonneService.findAll().subscribe((data) => this.abonnes = data);
    }


    get abonne(): AbonneDto {
       return this.abonneService.item;
    }
    set abonne(value: AbonneDto) {
        this.abonneService.item = value;
    }
    get abonnes():Array<AbonneDto> {
       return this.abonneService.items;
    }
    set abonnes(value: Array<AbonneDto>) {
        this.abonneService.items = value;
    }


}
