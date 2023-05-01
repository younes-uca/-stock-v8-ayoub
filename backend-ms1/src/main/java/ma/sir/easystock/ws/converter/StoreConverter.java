package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.easystock.zynerator.util.ListUtil;

import ma.sir.easystock.bean.core.Societe;

import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.StoreHistory;
import ma.sir.easystock.bean.core.Store;
import ma.sir.easystock.ws.dto.StoreDto;

@Component
public class StoreConverter extends AbstractConverter<Store, StoreDto, StoreHistory> {

    @Autowired
    private SocieteConverter societeConverter ;
    @Autowired
    private MagasinConverter magasinConverter ;
    private boolean societe;
    private boolean magasins;

    public  StoreConverter(){
        super(Store.class, StoreDto.class, StoreHistory.class);
        init(true);
    }

    @Override
    public Store toItem(StoreDto dto) {
        if (dto == null) {
            return null;
        } else {
        Store item = new Store();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(dto.getSociete() != null && dto.getSociete().getId() != null){
                item.setSociete(new Societe());
                item.getSociete().setId(dto.getSociete().getId());
            }


            if(this.magasins && ListUtil.isNotEmpty(dto.getMagasins()))
                item.setMagasins(magasinConverter.toItem(dto.getMagasins()));

        return item;
        }
    }

    @Override
    public StoreDto toDto(Store item) {
        if (item == null) {
            return null;
        } else {
            StoreDto dto = new StoreDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }
        if(this.magasins && ListUtil.isNotEmpty(item.getMagasins())){
            magasinConverter.init(true);
            magasinConverter.setStore(false);
            dto.setMagasins(magasinConverter.toDto(item.getMagasins()));
            magasinConverter.setStore(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.magasins = value;
    }

    public void initObject(boolean value) {
        this.societe = value;
    }


    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public MagasinConverter getMagasinConverter(){
        return this.magasinConverter;
    }
    public void setMagasinConverter(MagasinConverter magasinConverter ){
        this.magasinConverter = magasinConverter;
    }
    public boolean  isSociete(){
        return this.societe;
    }
    public void  setSociete(boolean societe){
        this.societe = societe;
    }
    public boolean  isMagasins(){
        return this.magasins ;
    }
    public void  setMagasins(boolean magasins ){
        this.magasins  = magasins ;
    }
}
