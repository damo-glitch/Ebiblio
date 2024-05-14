package org.myproject.ebiblio;

import org.junit.jupiter.api.Test;
import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Dto.BookDto;
import org.myproject.ebiblio.Entities.Enum.BookStatus;
import org.myproject.ebiblio.Mapper.BookMapper;
import org.myproject.ebiblio.Repositories.BookRepository;
import org.myproject.ebiblio.Services.ServicesImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class EbiblioApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookServiceImpl bookService;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void TestSaveBook() {
//        BookDto bookDto = new BookDto();
//        bookDto.setAuthor("Moiii");
//        bookDto.setEditor("Moiii");
//        bookDto.setInStock(10);
//        bookDto.setIsbn(UUID.randomUUID());
//        bookDto.setTitle("Mon livre à moii");
//        bookDto.setBookStatus(BookStatus.AVAILABLE);
//        bookDto.setDateOfPublication(java.time.LocalDate.now());
//        bookDto.setPriceBuy(5000.0);
//        Book book = bookService.saveBook(BookMapper.mapToEntity(bookDto));
//        System.out.println(book);
//        //bookRepository.save();
//    }
}
