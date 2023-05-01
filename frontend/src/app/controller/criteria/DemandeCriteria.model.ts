import {MagasinCriteria} from './MagasinCriteria.model';
import {EtatDemandeCriteria} from './EtatDemandeCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {PaiementDemandeCriteria} from './PaiementDemandeCriteria.model';
import {LivraisonCriteria} from './LivraisonCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {DemandeItemCriteria} from './DemandeItemCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DemandeCriteria  extends   BaseCriteria  {

    public id: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public livraison: LivraisonCriteria ;
  public livraisons: Array<LivraisonCriteria> ;
  public magasin: MagasinCriteria ;
  public magasins: Array<MagasinCriteria> ;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;
  public etatDemande: EtatDemandeCriteria ;
  public etatDemandes: Array<EtatDemandeCriteria> ;
      public demandeItems: Array<DemandeItemCriteria>;
      public paiementDemandes: Array<PaiementDemandeCriteria>;

}
