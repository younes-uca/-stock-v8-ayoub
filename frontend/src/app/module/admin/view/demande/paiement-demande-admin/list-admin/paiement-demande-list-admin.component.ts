import {Component, OnInit} from '@angular/core';
import {PaiementDemandeService} from 'src/app/controller/service/PaiementDemande.service';
import {PaiementDemandeDto} from 'src/app/controller/model/PaiementDemande.model';
import {PaiementDemandeCriteria} from 'src/app/controller/criteria/PaiementDemandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { DemandeService } from 'src/app/controller/service/Demande.service';
import { ModePaiementService } from 'src/app/controller/service/ModePaiement.service';
import { InstrumentPaiementService } from 'src/app/controller/service/InstrumentPaiement.service';
import { EtatPaiementDemandeService } from 'src/app/controller/service/EtatPaiementDemande.service';

import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {EtatPaiementDemandeDto} from 'src/app/controller/model/EtatPaiementDemande.model';


@Component({
  selector: 'app-paiement-demande-list-admin',
  templateUrl: './paiement-demande-list-admin.component.html'
})
export class PaiementDemandeListAdminComponent extends AbstractListController<PaiementDemandeDto, PaiementDemandeCriteria, PaiementDemandeService>  implements OnInit {

    fileName = 'PaiementDemande';

    demandes :Array<DemandeDto>;
    modePaiements :Array<ModePaiementDto>;
    instrumentPaiements :Array<InstrumentPaiementDto>;
    etatPaiementDemandes :Array<EtatPaiementDemandeDto>;
  
    constructor(paiementDemandeService: PaiementDemandeService, private demandeService: DemandeService, private modePaiementService: ModePaiementService, private instrumentPaiementService: InstrumentPaiementService, private etatPaiementDemandeService: EtatPaiementDemandeService) {
        super(paiementDemandeService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadDemande();
      this.loadModePaiement();
      this.loadInstrumentPaiement();
      this.loadEtatPaiementDemande();
    }

    public async loadPaiementDemandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.service.findAll().subscribe(paiementDemandes => this.items = paiementDemandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'datePaiement', header: 'Date paiement'},
            {field: 'montant', header: 'Montant'},
            {field: 'demande?.id', header: 'Demande'},
            {field: 'modePaiement?.libelle', header: 'Mode paiement'},
            {field: 'dateEcheance', header: 'Date echeance'},
            {field: 'instrumentPaiement?.libelle', header: 'Instrument paiement'},
            {field: 'referenceInstrumentPaiement', header: 'Reference instrument paiement'},
            {field: 'dateDepose', header: 'Date depose'},
            {field: 'photoChequeEffet', header: 'Photo cheque effet'},
            {field: 'etatPaiementDemande?.libelle', header: 'Etat paiement demande'},
        ];
    }


    public async loadDemande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.demandeService.findAll().subscribe(demandes => this.demandes = demandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadModePaiement(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.modePaiementService.findAllOptimized().subscribe(modePaiements => this.modePaiements = modePaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadInstrumentPaiement(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.instrumentPaiementService.findAllOptimized().subscribe(instrumentPaiements => this.instrumentPaiements = instrumentPaiements,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatPaiementDemande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaiementDemande', 'list');
        isPermistted ? this.etatPaiementDemandeService.findAllOptimized().subscribe(etatPaiementDemandes => this.etatPaiementDemandes = etatPaiementDemandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaiementDemandeDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Date paiement': this.datePipe.transform(e.datePaiement , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Demande': e.demande?.id ,
                'Mode paiement': e.modePaiement?.libelle ,
                 'Description': e.description ,
                'Date echeance': this.datePipe.transform(e.dateEcheance , 'dd/MM/yyyy hh:mm'),
                'Instrument paiement': e.instrumentPaiement?.libelle ,
                 'Reference instrument paiement': e.referenceInstrumentPaiement ,
                'Date depose': this.datePipe.transform(e.dateDepose , 'dd/MM/yyyy hh:mm'),
                 'Photo cheque effet': e.photoChequeEffet ,
                'Etat paiement demande': e.etatPaiementDemande?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Date paiement Min': this.criteria.datePaiementFrom ? this.datePipe.transform(this.criteria.datePaiementFrom , this.dateFormat) : environment.emptyForExport ,
            'Date paiement Max': this.criteria.datePaiementTo ? this.datePipe.transform(this.criteria.datePaiementTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Demande': this.criteria.demande?.id ? this.criteria.demande?.id : environment.emptyForExport ,
        //'Mode paiement': this.criteria.modePaiement?.libelle ? this.criteria.modePaiement?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Date echeance Min': this.criteria.dateEcheanceFrom ? this.datePipe.transform(this.criteria.dateEcheanceFrom , this.dateFormat) : environment.emptyForExport ,
            'Date echeance Max': this.criteria.dateEcheanceTo ? this.datePipe.transform(this.criteria.dateEcheanceTo , this.dateFormat) : environment.emptyForExport ,
        //'Instrument paiement': this.criteria.instrumentPaiement?.libelle ? this.criteria.instrumentPaiement?.libelle : environment.emptyForExport ,
            'Reference instrument paiement': this.criteria.referenceInstrumentPaiement ? this.criteria.referenceInstrumentPaiement : environment.emptyForExport ,
            'Date depose Min': this.criteria.dateDeposeFrom ? this.datePipe.transform(this.criteria.dateDeposeFrom , this.dateFormat) : environment.emptyForExport ,
            'Date depose Max': this.criteria.dateDeposeTo ? this.datePipe.transform(this.criteria.dateDeposeTo , this.dateFormat) : environment.emptyForExport ,
            'Photo cheque effet': this.criteria.photoChequeEffet ? this.criteria.photoChequeEffet : environment.emptyForExport ,
        //'Etat paiement demande': this.criteria.etatPaiementDemande?.libelle ? this.criteria.etatPaiementDemande?.libelle : environment.emptyForExport ,
        }];
      }
}
