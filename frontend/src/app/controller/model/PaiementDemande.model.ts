import {InstrumentPaiementDto} from './InstrumentPaiement.model';
import {DemandeDto} from './Demande.model';
import {ModePaiementDto} from './ModePaiement.model';
import {EtatPaiementDemandeDto} from './EtatPaiementDemande.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaiementDemandeDto  extends BaseDto{

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
    public demande: DemandeDto ;
    public modePaiement: ModePaiementDto ;
    public instrumentPaiement: InstrumentPaiementDto ;
    public etatPaiementDemande: EtatPaiementDemandeDto ;

}
