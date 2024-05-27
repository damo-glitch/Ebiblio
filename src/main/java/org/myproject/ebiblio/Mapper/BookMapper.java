package org.myproject.ebiblio.Mapper;

import org.modelmapper.ModelMapper;
import org.myproject.ebiblio.Entities.Dto.BookDto;
import org.myproject.ebiblio.Entities.Book;

import java.util.List;

public class BookMapper {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    /**
     * Cette méthode permet de mapper un objet Book vers un objet BookDto
     * @param book
     * @return BookDto
     */
    public static BookDto mapToDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    /**
     * Cette méthode permet de mapper un objet BookDto vers un objet Book
     * @param bookDto
     * @return Book
     */
    public static Book mapToEntity(BookDto bookDto) {
        return modelMapper.map(bookDto, Book.class);
    }

    /**
     * Cette méthode permet de mapper une liste d'objets Book vers une liste d'objets BookDto
     * @param books
     * @return List<BookDto>
     */
    public static List<BookDto> mapToDtoList(List<Book> books) {
        return books.stream().map(BookMapper::mapToDto).toList();
    }

    /**
     * Cette méthode permet de mapper une liste d'objets BookDto vers une liste d'objets Book
     * @param bookDtos
     * @return List<Book>
     */
    public static List<Book> mapToEntityList(List<BookDto> bookDtos) {
        return bookDtos.stream().map(BookMapper::mapToEntity).toList();
    }
}
