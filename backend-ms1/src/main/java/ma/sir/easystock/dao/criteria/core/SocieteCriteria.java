package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SocieteCriteria extends  BaseCriteria  {

    private String ice;
    private String iceLike;
    private String siege;
    private String siegeLike;
    private Boolean bloqued;

    private AbonneCriteria abonne ;
    private List<AbonneCriteria> abonnes ;


    public SocieteCriteria(){}

    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getIceLike(){
        return this.iceLike;
    }
    public void setIceLike(String iceLike){
        this.iceLike = iceLike;
    }

    public String getSiege(){
        return this.siege;
    }
    public void setSiege(String siege){
        this.siege = siege;
    }
    public String getSiegeLike(){
        return this.siegeLike;
    }
    public void setSiegeLike(String siegeLike){
        this.siegeLike = siegeLike;
    }

    public Boolean getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }

    public AbonneCriteria getAbonne(){
        return this.abonne;
    }

    public void setAbonne(AbonneCriteria abonne){
        this.abonne = abonne;
    }
    public List<AbonneCriteria> getAbonnes(){
        return this.abonnes;
    }

    public void setAbonnes(List<AbonneCriteria> abonnes){
        this.abonnes = abonnes;
    }
}
