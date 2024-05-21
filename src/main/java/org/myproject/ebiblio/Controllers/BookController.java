package org.myproject.ebiblio.Controllers;

import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Dto.BookDto;
import org.myproject.ebiblio.Mapper.BookMapper;
import org.myproject.ebiblio.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api-v1-Elibrairy/books")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * API for save a book
     * @param book
     * @return bookDto
     */
    @PostMapping("/save")
    public ResponseEntity<BookDto> saveBook(@RequestBody Book book) {
        try {
            return new ResponseEntity<>(BookMapper.mapToDto(bookService.saveBook(book)), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * API for update a book
     * @param id
     * @param book
     * @return BookDto
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (!id.equals(book.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Book bookToUpdate = bookService.updateBook(book);
        if (bookToUpdate != null) {
            return new ResponseEntity<>(BookMapper.mapToDto(bookToUpdate), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * API for delete a book
     * @param id
     * @return Void
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBoodById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * API for get all books
     * @return List<BookDto>
     */
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        //return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
        return new ResponseEntity<>(BookMapper.mapToDtoList(bookService.getAllBooks()), HttpStatus.OK);
    }

    /**
     * API for get book by id
     * @param id
     * @return BookDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        //return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
        return new ResponseEntity<>(BookMapper.mapToDto(bookService.getBookById(id)), HttpStatus.OK);
    }



}
