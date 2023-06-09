import {Component, OnInit} from '@angular/core';
import {AvoirVenteService} from 'src/app/controller/service/AvoirVente.service';
import {AvoirVenteDto} from 'src/app/controller/model/AvoirVente.model';
import {AvoirVenteCriteria} from 'src/app/controller/criteria/AvoirVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { VenteService } from 'src/app/controller/service/Vente.service';

import {VenteDto} from 'src/app/controller/model/Vente.model';
import {AvoirVenteItemDto} from 'src/app/controller/model/AvoirVenteItem.model';


@Component({
  selector: 'app-avoir-vente-list-admin',
  templateUrl: './avoir-vente-list-admin.component.html'
})
export class AvoirVenteListAdminComponent extends AbstractListController<AvoirVenteDto, AvoirVenteCriteria, AvoirVenteService>  implements OnInit {

    fileName = 'AvoirVente';

    ventes :Array<VenteDto>;
  
    constructor(avoirVenteService: AvoirVenteService, private venteService: VenteService) {
        super(avoirVenteService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadVente();
    }

    public async loadAvoirVentes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AvoirVente', 'list');
        isPermistted ? this.service.findAll().subscribe(avoirVentes => this.items = avoirVentes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'dateAvoir', header: 'Date avoir'},
            {field: 'montant', header: 'Montant'},
            {field: 'vente?.reference', header: 'Vente'},
        ];
    }


    public async loadVente(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AvoirVente', 'list');
        isPermistted ? this.venteService.findAllOptimized().subscribe(ventes => this.ventes = ventes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: AvoirVenteDto) {
        if (res.avoirVenteItems != null) {
             res.avoirVenteItems.forEach(d => { d.avoirVente = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Date avoir': this.datePipe.transform(e.dateAvoir , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Vente': e.vente?.reference ,
            }
        });

        this.criteriaData = [{
            'Date avoir Min': this.criteria.dateAvoirFrom ? this.datePipe.transform(this.criteria.dateAvoirFrom , this.dateFormat) : environment.emptyForExport ,
            'Date avoir Max': this.criteria.dateAvoirTo ? this.datePipe.transform(this.criteria.dateAvoirTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Vente': this.criteria.vente?.reference ? this.criteria.vente?.reference : environment.emptyForExport ,
        }];
      }
}
