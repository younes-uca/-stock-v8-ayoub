import {SocieteDto} from './Societe.model';
import {MagasinDto} from './Magasin.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class StoreDto  extends BaseDto{

    public id: number;
    public libelle: string;
    public reference: string;
    public societe: SocieteDto ;
     public magasins: Array<MagasinDto>;

}
