import {Component, OnInit} from '@angular/core';
import {EtatLivraisonService} from 'src/app/controller/service/EtatLivraison.service';
import {EtatLivraisonDto} from 'src/app/controller/model/EtatLivraison.model';
import {EtatLivraisonCriteria} from 'src/app/controller/criteria/EtatLivraisonCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-livraison-list-admin',
  templateUrl: './etat-livraison-list-admin.component.html'
})
export class EtatLivraisonListAdminComponent extends AbstractListController<EtatLivraisonDto, EtatLivraisonCriteria, EtatLivraisonService>  implements OnInit {

    fileName = 'EtatLivraison';

  
    constructor(etatLivraisonService: EtatLivraisonService) {
        super(etatLivraisonService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatLivraisons(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatLivraison', 'list');
        isPermistted ? this.service.findAll().subscribe(etatLivraisons => this.items = etatLivraisons,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatLivraisonDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                 'Style': e.style ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Style': this.criteria.style ? this.criteria.style : environment.emptyForExport ,
        }];
      }
}
