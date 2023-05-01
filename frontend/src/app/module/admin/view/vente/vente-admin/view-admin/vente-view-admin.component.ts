import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {VenteService} from 'src/app/controller/service/Vente.service';
import {VenteDto} from 'src/app/controller/model/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/VenteCriteria.model';

import {PaiementVenteDto} from 'src/app/controller/model/PaiementVente.model';
import {PaiementVenteService} from 'src/app/controller/service/PaiementVente.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {EtatPaiementVenteDto} from 'src/app/controller/model/EtatPaiementVente.model';
import {EtatPaiementVenteService} from 'src/app/controller/service/EtatPaiementVente.service';
import {VenteItemDto} from 'src/app/controller/model/VenteItem.model';
import {VenteItemService} from 'src/app/controller/service/VenteItem.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
@Component({
  selector: 'app-vente-view-admin',
  templateUrl: './vente-view-admin.component.html'
})
export class VenteViewAdminComponent extends AbstractViewController<VenteDto, VenteCriteria, VenteService> implements OnInit {

    paiementVentes = new PaiementVenteDto();
    paiementVentess: Array<PaiementVenteDto> = [];
    venteItems = new VenteItemDto();
    venteItemss: Array<VenteItemDto> = [];

    constructor(private venteService: VenteService, private paiementVenteService: PaiementVenteService, private etatPaiementVenteService: EtatPaiementVenteService, private produitService: ProduitService, private venteItemService: VenteItemService, private instrumentPaiementService: InstrumentPaiementService, private modePaiementService: ModePaiementService, private clientService: ClientService, private storeService: StoreService){
        super(venteService);
    }

    ngOnInit(): void {
        this.paiementVentes.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.paiementVentes.instrumentPaiement = new InstrumentPaiementDto();
        this.instrumentPaiementService.findAll().subscribe((data) => this.instrumentPaiements = data);
        this.paiementVentes.etatPaiementVente = new EtatPaiementVenteDto();
        this.etatPaiementVenteService.findAll().subscribe((data) => this.etatPaiementVentes = data);
        this.venteItems.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }


    get etatPaiementVente(): EtatPaiementVenteDto {
       return this.etatPaiementVenteService.item;
    }
    set etatPaiementVente(value: EtatPaiementVenteDto) {
        this.etatPaiementVenteService.item = value;
    }
    get etatPaiementVentes():Array<EtatPaiementVenteDto> {
       return this.etatPaiementVenteService.items;
    }
    set etatPaiementVentes(value: Array<EtatPaiementVenteDto>) {
        this.etatPaiementVenteService.items = value;
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
    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get instrumentPaiement(): InstrumentPaiementDto {
       return this.instrumentPaiementService.item;
    }
    set instrumentPaiement(value: InstrumentPaiementDto) {
        this.instrumentPaiementService.item = value;
    }
    get instrumentPaiements():Array<InstrumentPaiementDto> {
       return this.instrumentPaiementService.items;
    }
    set instrumentPaiements(value: Array<InstrumentPaiementDto>) {
        this.instrumentPaiementService.items = value;
    }
    get store(): StoreDto {
       return this.storeService.item;
    }
    set store(value: StoreDto) {
        this.storeService.item = value;
    }
    get stores():Array<StoreDto> {
       return this.storeService.items;
    }
    set stores(value: Array<StoreDto>) {
        this.storeService.items = value;
    }
    get modePaiement(): ModePaiementDto {
       return this.modePaiementService.item;
    }
    set modePaiement(value: ModePaiementDto) {
        this.modePaiementService.item = value;
    }
    get modePaiements():Array<ModePaiementDto> {
       return this.modePaiementService.items;
    }
    set modePaiements(value: Array<ModePaiementDto>) {
        this.modePaiementService.items = value;
    }


}
