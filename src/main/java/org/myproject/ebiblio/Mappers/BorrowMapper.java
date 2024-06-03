package org.myproject.ebiblio.Mappers;

import org.modelmapper.ModelMapper;
import org.myproject.ebiblio.Entities.Borrow;
import org.myproject.ebiblio.Entities.Dto.BorrowDto;

import java.util.List;

public class BorrowMapper {
    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    /**
     * Cette méthode permet de mapper un objet Borrow vers un objet BorrowDto
     * @param borrow
     * @return BorrowDto
     */
    public static BorrowDto mapToDto(Borrow borrow) {
        return modelMapper.map(borrow, BorrowDto.class);
    }

    /**
     * Cette méthode Permet de mapper un objet BorrowDto vers un objet Borrow
     * @param borrowDto
     * @return Borrow
     */
    public static Borrow mapToEntity(BorrowDto borrowDto) {
        return modelMapper.map(borrowDto, Borrow.class);
    }

    /**
     * Cette méthode permet de mapper une liste d'objets Borrow vers une liste d'objets BorrowDto
     * @param borrows
     * @return List<BorrowDto>
     */
    public static List<BorrowDto> mapToDtoList(List<Borrow> borrows) {
        return borrows.stream().map(BorrowMapper::mapToDto).toList();
    }

    /**
     * Cette méthode permet de mapper une liste d'objets BorrowDto vers une liste d'objets Borrow
     * @param borrowDto
     * @return List<Borrow>
     */
    public static List<Borrow> mapToEntityList(List<BorrowDto> borrowDto) {
        return borrowDto.stream().map(BorrowMapper::mapToEntity).toList();
    }
}
