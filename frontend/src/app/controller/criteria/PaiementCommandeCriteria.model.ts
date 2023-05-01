import {EtatPaiementCommandeCriteria} from './EtatPaiementCommandeCriteria.model';
import {InstrumentPaiementCriteria} from './InstrumentPaiementCriteria.model';
import {CommandeCriteria} from './CommandeCriteria.model';
import {ModePaiementCriteria} from './ModePaiementCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PaiementCommandeCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public datePaiement: Date;
    public datePaiementFrom: Date;
    public datePaiementTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
    public description: string;
    public descriptionLike: string;
    public dateEcheance: Date;
    public dateEcheanceFrom: Date;
    public dateEcheanceTo: Date;
    public referenceInstrumentPaiement: string;
    public referenceInstrumentPaiementLike: string;
    public dateDepose: Date;
    public dateDeposeFrom: Date;
    public dateDeposeTo: Date;
    public photoChequeEffet: string;
    public photoChequeEffetLike: string;
  public commande: CommandeCriteria ;
  public commandes: Array<CommandeCriteria> ;
  public modePaiement: ModePaiementCriteria ;
  public modePaiements: Array<ModePaiementCriteria> ;
  public instrumentPaiement: InstrumentPaiementCriteria ;
  public instrumentPaiements: Array<InstrumentPaiementCriteria> ;
  public etatPaiementCommande: EtatPaiementCommandeCriteria ;
  public etatPaiementCommandes: Array<EtatPaiementCommandeCriteria> ;

}
