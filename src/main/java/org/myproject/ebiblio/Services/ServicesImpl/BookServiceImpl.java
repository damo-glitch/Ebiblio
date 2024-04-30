package org.myproject.ebiblio.Services.ServicesImpl;

import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Repositories.BookRepository;
import org.myproject.ebiblio.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Cette méthode permet de sauvegarder un livre
     * @param book
     * @return book
     */

    @Override
    public Book saveBook(Book book) {
        return null;
    }

    /**
     * Cette méthode permet de mettre à jour un livre
     * @param book
     * @return
     */
    @Override
    public Book updateBook(Book book) {
        return null;
    }

    /**
     * Cette méthode permet de supprimer un livre
     * @param book
     */
    @Override
    public void deleteBook(Book book) {

    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Book BuyBook(Book book) {
        return null;
    }

    @Override
    public Book borrowBook(Book book) {
        return null;
    }

    @Override
    public Book reverseBook(Book book) {
        return null;
    }
}
