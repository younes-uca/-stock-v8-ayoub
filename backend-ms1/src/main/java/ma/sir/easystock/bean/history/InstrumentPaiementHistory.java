package ma.sir.easystock.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "instrument_paiement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="instrument_paiement_seq",sequenceName="instrument_paiement_seq",allocationSize=1, initialValue = 1)
public class InstrumentPaiementHistory extends HistBusinessObject  {


    public InstrumentPaiementHistory() {
    super();
    }

    public InstrumentPaiementHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="instrument_paiement_seq")
    public Long getId() {
    return id;
    }
}

