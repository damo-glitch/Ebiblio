package org.myproject.ebiblio.Mapper;

import org.modelmapper.ModelMapper;
import org.myproject.ebiblio.Entities.Dto.BookDto;
import org.myproject.ebiblio.Entities.Book;

public class BookMapper {

    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public static BookDto mapToDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    public static Book mapToEntity(BookDto bookDto) {
        return modelMapper.map(bookDto, Book.class);
    }
}
