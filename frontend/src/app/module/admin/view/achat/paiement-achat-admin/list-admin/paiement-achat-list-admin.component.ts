import {Component, OnInit} from '@angular/core';
import {PaiementAchatService} from 'src/app/controller/service/PaiementAchat.service';
import {PaiementAchatDto} from 'src/app/controller/model/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/PaiementAchatCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { AchatService } from 'src/app/controller/service/Achat.service';
import { ModePaiementService } from 'src/app/controller/service/ModePaiement.service';
import { InstrumentPaiementService } from 'src/app/controller/service/InstrumentPaiement.service';
import { EtatPaiementAchatService } from 'src/app/controller/service/EtatPaiementAchat.service';

import {EtatPaiementAchatDto} from 'src/app/controller/model/EtatPaiementAchat.model';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {AchatDto} from 'src/app/controller/model/Achat.model';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';


@Component({
  selector: 'app-paiement-achat-list-admin',
  templateUrl: './paiement-achat-list-admin.component.html'
})
export class PaiementAchatListAdminComponent extends AbstractListController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatService>  implements OnInit {

    fileName = 'PaiementAchat';

    achats :Array<AchatDto>;
    modePaiements :Array<ModePaiementDto>;
    instrumentPaiements :Array<InstrumentPaiementDto>;
    etatPaiementAchats :Array<EtatPaiementAchatDto>;
  
    constructor(paiementAchatService: PaiementAchatService, private achatService: AchatService, private modePaiementService: ModePaiementService, private instrumentPaiementService: InstrumentPaiementService, private etatPaiementAchatService: EtatPaiementAchatService) {
        super(paiementAchatService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadAchat();
      this.loadModePaiement();
      this.loadInstrumentPaiement();
      this.loadEtatPaiementAchat();
    }

    public async loadPaiementAchats(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementAchat', 'list');
        isPermistted ? this.service.findAll().subscribe(paiementAchats => this.items = paiementAchats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'achat?.reference', header: 'Achat'},
            {field: 'modePaiement?.libelle', header: 'Mode paiement'},
            {field: 'dateEcheance', header: 'Date echeance'},
            {field: 'instrumentPaiement?.libelle', header: 'Instrument paiement'},
            {field: 'referenceInstrumentPaiement', header: 'Reference instrument paiement'},
            {field: 'dateDepose', header: 'Date depose'},
            {field: 'photoChequeEffet', header: 'Photo cheque effet'},
            {field: 'etatPaiementAchat?.libelle', header: 'Etat paiement achat'},
        ];
    }


    public async loadAchat(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementAchat', 'list');
        isPermistted ? this.achatService.findAllOptimized().subscribe(achats => this.achats = achats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadModePaiement(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementAchat', 'list');
        isPermistted ? this.modePaiementService.findAllOptimized().subscribe(modePaiements => this.modePaiements = modePaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadInstrumentPaiement(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementAchat', 'list');
        isPermistted ? this.instrumentPaiementService.findAllOptimized().subscribe(instrumentPaiements => this.instrumentPaiements = instrumentPaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatPaiementAchat(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementAchat', 'list');
        isPermistted ? this.etatPaiementAchatService.findAllOptimized().subscribe(etatPaiementAchats => this.etatPaiementAchats = etatPaiementAchats,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaiementAchatDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Achat': e.achat?.reference ,
                'Mode paiement': e.modePaiement?.libelle ,
                 'Description': e.description ,
                'Date echeance': this.datePipe.transform(e.dateEcheance , 'dd/MM/yyyy hh:mm'),
                'Instrument paiement': e.instrumentPaiement?.libelle ,
                 'Reference instrument paiement': e.referenceInstrumentPaiement ,
                'Date depose': this.datePipe.transform(e.dateDepose , 'dd/MM/yyyy hh:mm'),
                 'Photo cheque effet': e.photoChequeEffet ,
                'Etat paiement achat': e.etatPaiementAchat?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Achat': this.criteria.achat?.reference ? this.criteria.achat?.reference : environment.emptyForExport ,
        //'Mode paiement': this.criteria.modePaiement?.libelle ? this.criteria.modePaiement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Date echeance Min': this.criteria.dateEcheanceFrom ? this.datePipe.transform(this.criteria.dateEcheanceFrom , this.dateFormat) : environment.emptyForExport ,
            'Date echeance Max': this.criteria.dateEcheanceTo ? this.datePipe.transform(this.criteria.dateEcheanceTo , this.dateFormat) : environment.emptyForExport ,
        //'Instrument paiement': this.criteria.instrumentPaiement?.libelle ? this.criteria.instrumentPaiement?.libelle : environment.emptyForExport ,
            'Reference instrument paiement': this.criteria.referenceInstrumentPaiement ? this.criteria.referenceInstrumentPaiement : environment.emptyForExport ,
            'Date depose Min': this.criteria.dateDeposeFrom ? this.datePipe.transform(this.criteria.dateDeposeFrom , this.dateFormat) : environment.emptyForExport ,
            'Date depose Max': this.criteria.dateDeposeTo ? this.datePipe.transform(this.criteria.dateDeposeTo , this.dateFormat) : environment.emptyForExport ,
            'Photo cheque effet': this.criteria.photoChequeEffet ? this.criteria.photoChequeEffet : environment.emptyForExport ,
        //'Etat paiement achat': this.criteria.etatPaiementAchat?.libelle ? this.criteria.etatPaiementAchat?.libelle : environment.emptyForExport ,
        }];
      }
}
