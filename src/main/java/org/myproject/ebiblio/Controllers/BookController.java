package org.myproject.ebiblio.Controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
        return new ResponseEntity<>(BookMapper.mapToDto(bookService.saveBook(book)), HttpStatus.CREATED);
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
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    /**
     * API for get book by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
}
