import {EtatPaiementCommandeDto} from './EtatPaiementCommande.model';
import {InstrumentPaiementDto} from './InstrumentPaiement.model';
import {CommandeDto} from './Commande.model';
import {ModePaiementDto} from './ModePaiement.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaiementCommandeDto  extends BaseDto{

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
    public commande: CommandeDto ;
    public modePaiement: ModePaiementDto ;
    public instrumentPaiement: InstrumentPaiementDto ;
    public etatPaiementCommande: EtatPaiementCommandeDto ;

}
