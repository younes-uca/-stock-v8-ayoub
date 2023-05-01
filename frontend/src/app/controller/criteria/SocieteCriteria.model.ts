import {AbonneCriteria} from './AbonneCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SocieteCriteria  extends   BaseCriteria  {

    public id: number;
    public ice: string;
    public iceLike: string;
    public siege: string;
    public siegeLike: string;
    public bloqued: null | boolean;
  public abonne: AbonneCriteria ;
  public abonnes: Array<AbonneCriteria> ;
      public stores: Array<StoreCriteria>;

}
