import {EtatPaiementAchatDto} from './EtatPaiementAchat.model';
import {InstrumentPaiementDto} from './InstrumentPaiement.model';
import {AchatDto} from './Achat.model';
import {ModePaiementDto} from './ModePaiement.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaiementAchatDto  extends BaseDto{

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
    public achat: AchatDto ;
    public modePaiement: ModePaiementDto ;
    public instrumentPaiement: InstrumentPaiementDto ;
    public etatPaiementAchat: EtatPaiementAchatDto ;

}
