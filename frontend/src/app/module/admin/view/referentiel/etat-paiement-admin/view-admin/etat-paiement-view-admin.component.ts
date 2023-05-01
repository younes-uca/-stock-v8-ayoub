import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatPaiementService} from 'src/app/controller/service/EtatPaiement.service';
import {EtatPaiementDto} from 'src/app/controller/model/EtatPaiement.model';
import {EtatPaiementCriteria} from 'src/app/controller/criteria/EtatPaiementCriteria.model';

@Component({
  selector: 'app-etat-paiement-view-admin',
  templateUrl: './etat-paiement-view-admin.component.html'
})
export class EtatPaiementViewAdminComponent extends AbstractViewController<EtatPaiementDto, EtatPaiementCriteria, EtatPaiementService> implements OnInit {


    constructor(private etatPaiementService: EtatPaiementService){
        super(etatPaiementService);
    }

    ngOnInit(): void {
    }




}
