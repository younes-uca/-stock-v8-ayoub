package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.ClassComptableHistory;
import ma.sir.easystock.bean.core.ClassComptable;
import ma.sir.easystock.ws.dto.ClassComptableDto;

@Component
public class ClassComptableConverter extends AbstractConverter<ClassComptable, ClassComptableDto, ClassComptableHistory> {

    @Autowired
    private SousClassComptableConverter sousClassComptableConverter ;
    @Autowired
    private CompteComptableConverter compteComptableConverter ;
    private boolean sousClassComptables;

    public  ClassComptableConverter(){
        super(ClassComptable.class, ClassComptableDto.class, ClassComptableHistory.class);
        init(true);
    }

    @Override
    public ClassComptable toItem(ClassComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        ClassComptable item = new ClassComptable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());

            if(this.sousClassComptables && ListUtil.isNotEmpty(dto.getSousClassComptables()))
                item.setSousClassComptables(sousClassComptableConverter.toItem(dto.getSousClassComptables()));

        return item;
        }
    }

    @Override
    public ClassComptableDto toDto(ClassComptable item) {
        if (item == null) {
            return null;
        } else {
            ClassComptableDto dto = new ClassComptableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
        if(this.sousClassComptables && ListUtil.isNotEmpty(item.getSousClassComptables())){
            sousClassComptableConverter.init(true);
            sousClassComptableConverter.setClassComptable(false);
            dto.setSousClassComptables(sousClassComptableConverter.toDto(item.getSousClassComptables()));
            sousClassComptableConverter.setClassComptable(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.sousClassComptables = value;
    }

    public void initObject(boolean value) {
    }


    public SousClassComptableConverter getSousClassComptableConverter(){
        return this.sousClassComptableConverter;
    }
    public void setSousClassComptableConverter(SousClassComptableConverter sousClassComptableConverter ){
        this.sousClassComptableConverter = sousClassComptableConverter;
    }
    public CompteComptableConverter getCompteComptableConverter(){
        return this.compteComptableConverter;
    }
    public void setCompteComptableConverter(CompteComptableConverter compteComptableConverter ){
        this.compteComptableConverter = compteComptableConverter;
    }
    public boolean  isSousClassComptables(){
        return this.sousClassComptables ;
    }
    public void  setSousClassComptables(boolean sousClassComptables ){
        this.sousClassComptables  = sousClassComptables ;
    }
}
