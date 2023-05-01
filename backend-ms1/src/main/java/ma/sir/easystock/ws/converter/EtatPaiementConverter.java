package  ma.sir.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.easystock.zynerator.util.StringUtil;
import ma.sir.easystock.zynerator.converter.AbstractConverter;
import ma.sir.easystock.zynerator.util.DateUtil;
import ma.sir.easystock.bean.history.EtatPaiementHistory;
import ma.sir.easystock.bean.core.EtatPaiement;
import ma.sir.easystock.ws.dto.EtatPaiementDto;

@Component
public class EtatPaiementConverter extends AbstractConverter<EtatPaiement, EtatPaiementDto, EtatPaiementHistory> {


    public  EtatPaiementConverter(){
        super(EtatPaiement.class, EtatPaiementDto.class, EtatPaiementHistory.class);
    }

    @Override
    public EtatPaiement toItem(EtatPaiementDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatPaiement item = new EtatPaiement();
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
    public EtatPaiementDto toDto(EtatPaiement item) {
        if (item == null) {
            return null;
        } else {
            EtatPaiementDto dto = new EtatPaiementDto();
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
