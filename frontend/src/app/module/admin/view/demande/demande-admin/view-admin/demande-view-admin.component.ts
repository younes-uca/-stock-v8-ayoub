import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DemandeService} from 'src/app/controller/service/Demande.service';
import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {DemandeCriteria} from 'src/app/controller/criteria/DemandeCriteria.model';

import {EtatDemandeDto} from 'src/app/controller/model/EtatDemande.model';
import {EtatDemandeService} from 'src/app/controller/service/EtatDemande.service';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {ProduitService} from 'src/app/controller/service/Produit.service';
import {DemandeItemDto} from 'src/app/controller/model/DemandeItem.model';
import {DemandeItemService} from 'src/app/controller/service/DemandeItem.service';
import {LivraisonDto} from 'src/app/controller/model/Livraison.model';
import {LivraisonService} from 'src/app/controller/service/Livraison.service';
import {InstrumentPaiementDto} from 'src/app/controller/model/InstrumentPaiement.model';
import {InstrumentPaiementService} from 'src/app/controller/service/InstrumentPaiement.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {EtatPaiementDemandeDto} from 'src/app/controller/model/EtatPaiementDemande.model';
import {EtatPaiementDemandeService} from 'src/app/controller/service/EtatPaiementDemande.service';
import {PaiementDemandeDto} from 'src/app/controller/model/PaiementDemande.model';
import {PaiementDemandeService} from 'src/app/controller/service/PaiementDemande.service';
import {ModePaiementDto} from 'src/app/controller/model/ModePaiement.model';
import {ModePaiementService} from 'src/app/controller/service/ModePaiement.service';
import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {MagasinService} from 'src/app/controller/service/Magasin.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
@Component({
  selector: 'app-demande-view-admin',
  templateUrl: './demande-view-admin.component.html'
})
export class DemandeViewAdminComponent extends AbstractViewController<DemandeDto, DemandeCriteria, DemandeService> implements OnInit {

    demandeItems = new DemandeItemDto();
    demandeItemss: Array<DemandeItemDto> = [];
    paiementDemandes = new PaiementDemandeDto();
    paiementDemandess: Array<PaiementDemandeDto> = [];

    constructor(private demandeService: DemandeService, private etatDemandeService: EtatDemandeService, private produitService: ProduitService, private demandeItemService: DemandeItemService, private livraisonService: LivraisonService, private instrumentPaiementService: InstrumentPaiementService, private paiementDemandeService: PaiementDemandeService, private modePaiementService: ModePaiementService, private clientService: ClientService, private magasinService: MagasinService, private storeService: StoreService, private etatPaiementDemandeService: EtatPaiementDemandeService){
        super(demandeService);
    }

    ngOnInit(): void {
        this.demandeItems.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.paiementDemandes.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.paiementDemandes.instrumentPaiement = new InstrumentPaiementDto();
        this.instrumentPaiementService.findAll().subscribe((data) => this.instrumentPaiements = data);
        this.paiementDemandes.etatPaiementDemande = new EtatPaiementDemandeDto();
        this.etatPaiementDemandeService.findAll().subscribe((data) => this.etatPaiementDemandes = data);
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.livraison = new LivraisonDto();
        this.livraisonService.findAll().subscribe((data) => this.livraisons = data);
        this.magasin = new MagasinDto();
        this.magasinService.findAll().subscribe((data) => this.magasins = data);
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
        this.etatDemande = new EtatDemandeDto();
        this.etatDemandeService.findAll().subscribe((data) => this.etatDemandes = data);
    }


    get etatPaiementDemande(): EtatPaiementDemandeDto {
       return this.etatPaiementDemandeService.item;
    }
    set etatPaiementDemande(value: EtatPaiementDemandeDto) {
        this.etatPaiementDemandeService.item = value;
    }
    get etatPaiementDemandes():Array<EtatPaiementDemandeDto> {
       return this.etatPaiementDemandeService.items;
    }
    set etatPaiementDemandes(value: Array<EtatPaiementDemandeDto>) {
        this.etatPaiementDemandeService.items = value;
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
    get magasin(): MagasinDto {
       return this.magasinService.item;
    }
    set magasin(value: MagasinDto) {
        this.magasinService.item = value;
    }
    get magasins():Array<MagasinDto> {
       return this.magasinService.items;
    }
    set magasins(value: Array<MagasinDto>) {
        this.magasinService.items = value;
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
    get livraison(): LivraisonDto {
       return this.livraisonService.item;
    }
    set livraison(value: LivraisonDto) {
        this.livraisonService.item = value;
    }
    get livraisons():Array<LivraisonDto> {
       return this.livraisonService.items;
    }
    set livraisons(value: Array<LivraisonDto>) {
        this.livraisonService.items = value;
    }
    get etatDemande(): EtatDemandeDto {
       return this.etatDemandeService.item;
    }
    set etatDemande(value: EtatDemandeDto) {
        this.etatDemandeService.item = value;
    }
    get etatDemandes():Array<EtatDemandeDto> {
       return this.etatDemandeService.items;
    }
    set etatDemandes(value: Array<EtatDemandeDto>) {
        this.etatDemandeService.items = value;
    }


}
