package org.myproject.ebiblio.Mappers;


import org.modelmapper.ModelMapper;
import org.myproject.ebiblio.Entities.Buy;
import org.myproject.ebiblio.Entities.Dto.BuyDto;

import java.util.List;

public class BuyMapper {
    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    /**
     * Cette méthode permet de mapper un objet Buy vers un objet BuyDto
     * @param buy
     * @return buyDto
     */
    public static BuyDto mapToDto(Buy buy) {
        return modelMapper.map(buy, BuyDto.class);
    }


    /**
     * Cette méthode permet de mapper un objet BuyDto vers un objet Buy
     * @param buyDto
     * @return buy
     */
    public static Buy mapToEntity(BuyDto buyDto) {
        return modelMapper.map(buyDto, Buy.class);
    }


    /**
     * Cette méthode permet de mapper une liste d'objets Buy vers une liste d'objets BuyDto
     * @param buys
     * @return List<BuyDto>
     */
    public static List<BuyDto> mapToDtoList(List<Buy> buys) {
        return buys.stream().map(BuyMapper::mapToDto).toList();
    }

    /**
     * Cette méthode permet de mapper une liste d'objets BuyDto vers une liste d'objets Buy
     * @param buyDtos
     * @return List<Buy>
     */

    public static List<Buy> mapToEntityList(List<BuyDto> buyDtos) {
        return buyDtos.stream().map(BuyMapper::mapToEntity).toList();
    }


}
