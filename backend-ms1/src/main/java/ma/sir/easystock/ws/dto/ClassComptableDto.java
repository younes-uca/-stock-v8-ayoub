package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassComptableDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;


    private List<SousClassComptableDto> sousClassComptables ;


    public ClassComptableDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }





    public List<SousClassComptableDto> getSousClassComptables(){
        return this.sousClassComptables;
    }

    public void setSousClassComptables(List<SousClassComptableDto> sousClassComptables){
        this.sousClassComptables = sousClassComptables;
    }

}
