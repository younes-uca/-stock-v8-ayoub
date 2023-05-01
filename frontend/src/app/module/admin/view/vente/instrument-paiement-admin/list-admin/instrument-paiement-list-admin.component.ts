import {Component, OnInit} from '@angular/core';
import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementCriteria} from 'src/app/controller/criteria/InstrumentPaiementCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-instrument-paiement-list-admin',
  templateUrl: './instrument-paiement-list-admin.component.html'
})
export class InstrumentPaiementListAdminComponent extends AbstractListController<InstrumentPaiementDto, InstrumentPaiementCriteria, InstrumentPaiementService>  implements OnInit {

    fileName = 'InstrumentPaiement';

  
    constructor(instrumentPaiementService: InstrumentPaiementService) {
        super(instrumentPaiementService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadInstrumentPaiements(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('InstrumentPaiement', 'list');
        isPermistted ? this.service.findAll().subscribe(instrumentPaiements => this.items = instrumentPaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: InstrumentPaiementDto) {
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
