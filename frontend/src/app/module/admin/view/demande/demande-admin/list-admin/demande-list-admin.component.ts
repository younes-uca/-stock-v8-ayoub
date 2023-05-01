import {Component, OnInit} from '@angular/core';
import {DemandeService} from 'src/app/controller/service/Demande.service';
import {DemandeDto} from 'src/app/controller/model/Demande.model';
import {DemandeCriteria} from 'src/app/controller/criteria/DemandeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ProduitService } from 'src/app/controller/service/Produit.service';
import { ClientService } from 'src/app/controller/service/Client.service';
import { LivraisonService } from 'src/app/controller/service/Livraison.service';
import { MagasinService } from 'src/app/controller/service/Magasin.service';
import { StoreService } from 'src/app/controller/service/Store.service';
import { EtatDemandeService } from 'src/app/controller/service/EtatDemande.service';

import {MagasinDto} from 'src/app/controller/model/Magasin.model';
import {EtatDemandeDto} from 'src/app/controller/model/EtatDemande.model';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {PaiementDemandeDto} from 'src/app/controller/model/PaiementDemande.model';
import {LivraisonDto} from 'src/app/controller/model/Livraison.model';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ProduitDto} from 'src/app/controller/model/Produit.model';
import {DemandeItemDto} from 'src/app/controller/model/DemandeItem.model';


@Component({
  selector: 'app-demande-list-admin',
  templateUrl: './demande-list-admin.component.html'
})
export class DemandeListAdminComponent extends AbstractListController<DemandeDto, DemandeCriteria, DemandeService>  implements OnInit {

    fileName = 'Demande';

    produits :Array<ProduitDto>;
    clients :Array<ClientDto>;
    livraisons :Array<LivraisonDto>;
    magasins :Array<MagasinDto>;
    stores :Array<StoreDto>;
    etatDemandes :Array<EtatDemandeDto>;
  
    constructor(demandeService: DemandeService, private produitService: ProduitService, private clientService: ClientService, private livraisonService: LivraisonService, private magasinService: MagasinService, private storeService: StoreService, private etatDemandeService: EtatDemandeService) {
        super(demandeService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadProduit();
      this.loadClient();
      this.loadLivraison();
      this.loadMagasin();
      this.loadStore();
      this.loadEtatDemande();
    }

    public async loadDemandes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.service.findAll().subscribe(demandes => this.items = demandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.libelle', header: 'Produit'},
            {field: 'client?.nom', header: 'Client'},
            {field: 'livraison?.id', header: 'Livraison'},
            {field: 'magasin?.id', header: 'Magasin'},
            {field: 'store?.libelle', header: 'Store'},
            {field: 'etatDemande?.libelle', header: 'Etat demande'},
        ];
    }


    public async loadProduit(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.produitService.findAllOptimized().subscribe(produits => this.produits = produits,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadLivraison(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.livraisonService.findAll().subscribe(livraisons => this.livraisons = livraisons,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadMagasin(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.magasinService.findAll().subscribe(magasins => this.magasins = magasins,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadStore(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.storeService.findAllOptimized().subscribe(stores => this.stores = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatDemande(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demande', 'list');
        isPermistted ? this.etatDemandeService.findAllOptimized().subscribe(etatDemandes => this.etatDemandes = etatDemandes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DemandeDto) {
        if (res.demandeItems != null) {
             res.demandeItems.forEach(d => { d.demande = null; d.id = null; });
        }
        if (res.paiementDemandes != null) {
             res.paiementDemandes.forEach(d => { d.demande = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.libelle ,
                'Client': e.client?.nom ,
                'Livraison': e.livraison?.id ,
                'Magasin': e.magasin?.id ,
                'Store': e.store?.libelle ,
                'Etat demande': e.etatDemande?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.libelle ? this.criteria.produit?.libelle : environment.emptyForExport ,
        //'Client': this.criteria.client?.nom ? this.criteria.client?.nom : environment.emptyForExport ,
        //'Livraison': this.criteria.livraison?.id ? this.criteria.livraison?.id : environment.emptyForExport ,
        //'Magasin': this.criteria.magasin?.id ? this.criteria.magasin?.id : environment.emptyForExport ,
        //'Store': this.criteria.store?.libelle ? this.criteria.store?.libelle : environment.emptyForExport ,
        //'Etat demande': this.criteria.etatDemande?.libelle ? this.criteria.etatDemande?.libelle : environment.emptyForExport ,
        }];
      }
}
