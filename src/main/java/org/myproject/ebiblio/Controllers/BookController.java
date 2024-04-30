package org.myproject.ebiblio.Controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Dto.BookDto;
import org.myproject.ebiblio.Mapper.BookMapper;
import org.myproject.ebiblio.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
@NoArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/enregistrer-un-livre")
    public ResponseEntity<BookDto> saveBook(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(BookMapper.mapToDto(bookService.saveBook(book)));
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/modifier-un-livre")
    public ResponseEntity<BookDto> updateBook(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(BookMapper.mapToDto(bookService.updateBook(book)));
        }catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/supprimer-un-livre/{id}")
    public void deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(bookService.getBookById(id));
            ResponseEntity.status(200).build();
        }catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            ResponseEntity.status(400).build();
        }
    }


    @GetMapping("/tous-les-livres")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            return ResponseEntity.ok(bookService.getAllBooks());
        }catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
