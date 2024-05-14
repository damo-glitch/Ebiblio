package org.myproject.ebiblio.Services;

import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Enum.BookStatus;

import java.util.List;

public interface BookService {
    // ADMIN ACTIONS
    Book saveBook(Book book);

    Book updateBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void deleteBoodById(Long id);


    //--------//
    List<Book> getBooksAvailable();
    List<Book> getBooksBorrowed();
    List<Book> getBooksReserved();
    List<Book> getBooksByStatus(BookStatus status);

    // USERS ACTIONS
    Book BuyBook(Book book);

    Book borrowBook(Book book);

    Book reverseBook(Book book);



}
