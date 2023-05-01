import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementCriteria} from 'src/app/controller/criteria/InstrumentPaiementCriteria.model';

@Component({
  selector: 'app-instrument-paiement-view-admin',
  templateUrl: './instrument-paiement-view-admin.component.html'
})
export class InstrumentPaiementViewAdminComponent extends AbstractViewController<InstrumentPaiementDto, InstrumentPaiementCriteria, InstrumentPaiementService> implements OnInit {


    constructor(private instrumentPaiementService: InstrumentPaiementService){
        super(instrumentPaiementService);
    }

    ngOnInit(): void {
    }




}
