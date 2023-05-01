import {EtatPaiementVenteCriteria} from './EtatPaiementVenteCriteria.model';
import {VenteCriteria} from './VenteCriteria.model';
import {InstrumentPaiementCriteria} from './InstrumentPaiementCriteria.model';
import {ModePaiementCriteria} from './ModePaiementCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PaiementVenteCriteria  extends   BaseCriteria  {

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
  public vente: VenteCriteria ;
  public ventes: Array<VenteCriteria> ;
  public modePaiement: ModePaiementCriteria ;
  public modePaiements: Array<ModePaiementCriteria> ;
  public instrumentPaiement: InstrumentPaiementCriteria ;
  public instrumentPaiements: Array<InstrumentPaiementCriteria> ;
  public etatPaiementVente: EtatPaiementVenteCriteria ;
  public etatPaiementVentes: Array<EtatPaiementVenteCriteria> ;

}
