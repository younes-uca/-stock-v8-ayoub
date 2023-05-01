package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.InstrumentPaiementHistory;
import ma.sir.easystock.bean.core.InstrumentPaiement;
import ma.sir.easystock.ws.dto.InstrumentPaiementDto;

@Component
public class InstrumentPaiementConverter extends AbstractConverter<InstrumentPaiement, InstrumentPaiementDto, InstrumentPaiementHistory> {


    public  InstrumentPaiementConverter(){
        super(InstrumentPaiement.class, InstrumentPaiementDto.class, InstrumentPaiementHistory.class);
    }

    @Override
    public InstrumentPaiement toItem(InstrumentPaiementDto dto) {
        if (dto == null) {
            return null;
        } else {
        InstrumentPaiement item = new InstrumentPaiement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getStyle()))
                item.setStyle(dto.getStyle());


        return item;
        }
    }

    @Override
    public InstrumentPaiementDto toDto(InstrumentPaiement item) {
        if (item == null) {
            return null;
        } else {
            InstrumentPaiementDto dto = new InstrumentPaiementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getStyle()))
                dto.setStyle(item.getStyle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
