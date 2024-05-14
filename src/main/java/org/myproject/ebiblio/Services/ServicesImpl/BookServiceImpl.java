package org.myproject.ebiblio.Services.ServicesImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Enum.BookStatus;
import org.myproject.ebiblio.Repositories.BookRepository;
import org.myproject.ebiblio.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
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
        if(findBookByTitle(book.getTitle()) != null){
            throw new RuntimeException("Ce livre existe déjà");
        }
        return bookRepository.save(book);
    }

    /**
     * Cette méthode permet de mettre à jour un livre
     * @param book
     * @return book
     */
    @Override
    public Book updateBook(Book book) {
        if(!bookRepository.existsById(book.getId())){
            throw new RuntimeException("Ce livre n'existe pas");
        }
        return bookRepository.save(book);
    }

    /**
     * Cette méthode permet de lister les livres disponibles
     * @return List<Book>
     */
    @Override
    public List<Book> getBooksAvailable() {
        List<Book> books = bookRepository.findAll();
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookStatus() == BookStatus.AVAILABLE) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Cette méthode permet de lister les livres emprunés
     * @return List<Book>
     */
    @Override
    public List<Book> getBooksBorrowed() {
        List<Book> books = bookRepository.findAll();
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookStatus() == BookStatus.BORROWED) {
                result.add(book);
            }
        }
        return result;
    }


    /**
     * Cette fonction permet de lister les livres reservés
     * @return List<Book>
     */
    @Override
    public List<Book> getBooksReserved() {
        List<Book> books = bookRepository.findAll();
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookStatus() == BookStatus.RESERVED) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Cette méthode permet de lister les livres par statut
     * @param status
     * @return List<Book>
     */
    @Override
    public List<Book> getBooksByStatus(BookStatus status) {
        List<Book> books = bookRepository.findAll();
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookStatus() == status) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Cette méthode permet de lister tous les livres
     * @return List<Book>
     */
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Cette méthode permet de récuperer un livre par son id
     * @param id
     * @return Book
     */
    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    /**
     * Cette méthode permet de supprimer un livre par son id
     * @param id
     */
    @Override
    public void deleteBoodById(Long id) {
        bookRepository.deleteById(id);
    }

    //-- USERS or CUSTOMERS ACTIONS --//

    /**
     * Cette méthode permet d'acheter un livre
     * @param book
     * @return book
     */
    @Override
    public Book BuyBook(Book book) {
        Book b = bookRepository.findById(book.getId()).get();

        if(b.getBookStatus() == BookStatus.AVAILABLE){
            Integer inStock = b.getInStock() - 1;
            b.setInStock(inStock);

            String status = BookStatus.SOLD.toString();
            b.setBookStatus(BookStatus.valueOf(status));
        }
        return bookRepository.save(b);
    }

    /**
     * Cette méthode permet d'emprunter un livre
     * @param book
     * @return book
     */
    @Override
    public Book borrowBook(Book book) {
        Book bC = bookRepository.findById(book.getId()).get();

        if(bC.getBookStatus() == BookStatus.AVAILABLE){
            Integer inStock = bC.getInStock() - 1;
            bC.setInStock(inStock);

            String status = BookStatus.BORROWED.toString();
            bC.setBookStatus(BookStatus.valueOf(status));
        }
        return bookRepository.save(bC);
    }

    /**
     * Cette méthode permet de réserver un livre
     * @param book
     * @return book
     */
    @Override
    public Book reverseBook(Book book) {
        return null;
    }


    //-- PRIVATE METHODS --//
    private Book findBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }





}
