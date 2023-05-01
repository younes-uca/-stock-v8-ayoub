import {EtatPaiementVenteDto} from './EtatPaiementVente.model';
import {VenteDto} from './Vente.model';
import {InstrumentPaiementDto} from './InstrumentPaiement.model';
import {ModePaiementDto} from './ModePaiement.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaiementVenteDto  extends BaseDto{

    public id: number;
    public reference: string;
   public datePaiement: Date;
    public montant: number;
    public description: string;
   public dateEcheance: Date;
    public referenceInstrumentPaiement: string;
   public dateDepose: Date;
    public photoChequeEffet: string;
    public datePaiementMax: string ;
    public datePaiementMin: string ;
    public montantMax: string ;
    public montantMin: string ;
    public dateEcheanceMax: string ;
    public dateEcheanceMin: string ;
    public dateDeposeMax: string ;
    public dateDeposeMin: string ;
    public vente: VenteDto ;
    public modePaiement: ModePaiementDto ;
    public instrumentPaiement: InstrumentPaiementDto ;
    public etatPaiementVente: EtatPaiementVenteDto ;

}
