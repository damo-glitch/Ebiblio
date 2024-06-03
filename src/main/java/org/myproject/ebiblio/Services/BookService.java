package org.myproject.ebiblio.Services;

import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Borrow;
import org.myproject.ebiblio.Entities.Buy;

import java.util.List;

public interface BookService {
    // ADMIN ACTIONS
    Book saveBook(Book book);

    Book updateBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void deleteBoodById(Long id);


    // USERS ACTIONS
    void buyBook(Buy buy);

    void borrowBook(Borrow borrow);
}
