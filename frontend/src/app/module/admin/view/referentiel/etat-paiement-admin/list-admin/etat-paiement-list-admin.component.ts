import {Component, OnInit} from '@angular/core';
import {EtatPaiementService} from 'src/app/controller/service/EtatPaiement.service';
import {EtatPaiementDto} from 'src/app/controller/model/EtatPaiement.model';
import {EtatPaiementCriteria} from 'src/app/controller/criteria/EtatPaiementCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-paiement-list-admin',
  templateUrl: './etat-paiement-list-admin.component.html'
})
export class EtatPaiementListAdminComponent extends AbstractListController<EtatPaiementDto, EtatPaiementCriteria, EtatPaiementService>  implements OnInit {

    fileName = 'EtatPaiement';

  
    constructor(etatPaiementService: EtatPaiementService) {
        super(etatPaiementService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatPaiements(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatPaiement', 'list');
        isPermistted ? this.service.findAll().subscribe(etatPaiements => this.items = etatPaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: EtatPaiementDto) {
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
