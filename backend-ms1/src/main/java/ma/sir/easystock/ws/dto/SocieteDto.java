package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SocieteDto  extends AuditBaseDto {

    private String ice  ;
    private String siege  ;
    private Boolean bloqued  ;

    private AbonneDto abonne ;

    private List<StoreDto> stores ;


    public SocieteDto(){
        super();
    }



    @Log
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }

    @Log
    public String getSiege(){
        return this.siege;
    }
    public void setSiege(String siege){
        this.siege = siege;
    }

    @Log
    public Boolean getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }


    public AbonneDto getAbonne(){
        return this.abonne;
    }

    public void setAbonne(AbonneDto abonne){
        this.abonne = abonne;
    }



    public List<StoreDto> getStores(){
        return this.stores;
    }

    public void setStores(List<StoreDto> stores){
        this.stores = stores;
    }

}
