import {LivraisonCriteria} from './LivraisonCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class LivraisonItemCriteria  extends   BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public livraison: LivraisonCriteria ;
  public livraisons: Array<LivraisonCriteria> ;

}
