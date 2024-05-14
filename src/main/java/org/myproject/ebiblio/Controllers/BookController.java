package org.myproject.ebiblio.Controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Dto.BookDto;
import org.myproject.ebiblio.Entities.Enum.BookStatus;
import org.myproject.ebiblio.Mapper.BookMapper;
import org.myproject.ebiblio.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-v1-Elibrairy/books")
@AllArgsConstructor
@NoArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * API for save a book
     * @param book
     * @return book
     */
    @PostMapping("/saveBook")
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
     * @return book
     */
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody Book book) {
        if (!id.equals(book.getId())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (bookService.updateBook(book) != null) {
            return new ResponseEntity<>(BookMapper.mapToDto(bookService.updateBook(book)), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * API for delete a book
     * @param id
     * @return Void
     */
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBoodById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * API for get all books
     * @return
     */
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        //return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
        return new ResponseEntity<>(BookMapper.mapToDtoList(bookService.getAllBooks()), HttpStatus.OK);
    }

    /**
     * API for get book by id
     * @param id
     * @return
     */
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    /**
     * API for get books by status
     * @param status
     * @return
     */
    @GetMapping("/getBooksByStatus/{status}")
    public ResponseEntity<List<BookDto>> getBooksByStatus(@PathVariable String status) {
        BookStatus bookStatus = BookStatus.valueOf(status);
        //return new ResponseEntity<>(bookService.getBooksByStatus(bookStatus), HttpStatus.OK);
        return new ResponseEntity<>(BookMapper.mapToDtoList(bookService.getBooksByStatus(bookStatus)), HttpStatus.OK);
    }

    /**
     * API for get books available
     * @return List<Book>
     */
    @GetMapping("/getBooksAvailable")
    public ResponseEntity<List<BookDto>> getBooksAvailable() {
        //return new ResponseEntity<>(bookService.getBooksAvailable(), HttpStatus.OK);
        return new ResponseEntity<>(BookMapper.mapToDtoList(bookService.getBooksAvailable()), HttpStatus.OK);
    }

    /**
     * API for get books borrowed
     * @return List<Book>
     */
    @GetMapping("/getBooksBorrowed")
    public ResponseEntity<List<BookDto>> getBooksBorrowed() {
        //return new ResponseEntity<>(bookService.getBooksBorrowed(), HttpStatus.OK);
        return new ResponseEntity<>(BookMapper.mapToDtoList(bookService.getBooksBorrowed()), HttpStatus.OK);
    }

    /**
     * API for get books reserved
     * @return List<Book>
     */
    @GetMapping("/getBooksReserved")
    public ResponseEntity<List<BookDto>> getBooksReserved() {
        //return new ResponseEntity<>(bookService.getBooksReserved(), HttpStatus.OK);
        return new ResponseEntity<>(BookMapper.mapToDtoList(bookService.getBooksReserved()), HttpStatus.OK);
    }
}
