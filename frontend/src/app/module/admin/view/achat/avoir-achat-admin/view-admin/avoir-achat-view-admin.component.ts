import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AvoirAchatService} from 'src/app/controller/service/AvoirAchat.service';
import {AvoirAchatDto} from 'src/app/controller/model/AvoirAchat.model';
import {AvoirAchatCriteria} from 'src/app/controller/criteria/AvoirAchatCriteria.model';

import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {AchatDto} from 'src/app/controller/model/Achat.model';
import {AchatService} from 'src/app/controller/service/Achat.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/AvoirAchatItem.model';
import {AvoirAchatItemService} from 'src/app/controller/service/AvoirAchatItem.service';
@Component({
  selector: 'app-avoir-achat-view-admin',
  templateUrl: './avoir-achat-view-admin.component.html'
})
export class AvoirAchatViewAdminComponent extends AbstractViewController<AvoirAchatDto, AvoirAchatCriteria, AvoirAchatService> implements OnInit {

    avoirAchatItems = new AvoirAchatItemDto();
    avoirAchatItemss: Array<AvoirAchatItemDto> = [];

    constructor(private avoirAchatService: AvoirAchatService, private produitService: ProduitService, private achatService: AchatService, private avoirAchatItemService: AvoirAchatItemService){
        super(avoirAchatService);
    }

    ngOnInit(): void {
        this.avoirAchatItems.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
    }


    get produit(): ProduitDto {
       return this.produitService.item;
    }
    set produit(value: ProduitDto) {
        this.produitService.item = value;
    }
    get produits():Array<ProduitDto> {
       return this.produitService.items;
    }
    set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
    }
    get achat(): AchatDto {
       return this.achatService.item;
    }
    set achat(value: AchatDto) {
        this.achatService.item = value;
    }
    get achats():Array<AchatDto> {
       return this.achatService.items;
    }
    set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
    }


}
