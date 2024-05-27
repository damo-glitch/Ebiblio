package org.myproject.ebiblio.Services.ServicesImpl;

import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Borrow;
import org.myproject.ebiblio.Repositories.BookRepository;
import org.myproject.ebiblio.Repositories.BorrowRepository;
import org.myproject.ebiblio.Services.BookService;
import org.myproject.ebiblio.Services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowService borrowService;
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

        if(b.getInStock() != 0){
            Integer inStock = b.getInStock() - 1;
            b.setInStock(inStock);
            //String status = BookStatus.BORROWED.toString();
            //b.setBookStatus(BookStatus.valueOf(status));
        }
        return bookRepository.save(b);
    }

    /**
     * Cette méthode permet d'emprunter un livre
     * @param book
     * @return book
     */
    @Override
    public void borrowBook(Book book) {
        Book bC = bookRepository.findById(book.getId()).get();
         if(bC.getInStock() == 0){
             throw new RuntimeException("Ce livre n'est plus disponible");
         }else{
             //-- UPDATE BOOK IN_STOCK
             Integer inStock = bC.getInStock() - 1;
             bC.setInStock(inStock);

             Borrow borrow = new Borrow();
             borrow.setDateBorrow(LocalDate.now());
             borrow.setBook(bC);
             LocalDate date = borrow.getDateBorrow();
             Integer nbDays = borrow.getNumberDays();
             borrow.setDateExpired(date.plusDays(nbDays));
             borrowService.saveBorrow(borrow);
             bookRepository.save(bC);
         }




    }

    @Override
    public void borrBook(Borrow borrow) {
        Book b = bookRepository.findById(borrow.getBook().getId()).orElse(null);
        if(b == null || b.getInStock() == 0){
            throw new RuntimeException("Ce livre n'est plus disponible");
        }else{
            Integer inStock = b.getInStock() - 1;
            b.setInStock(inStock);
            bookRepository.save(b);
            borrow.setBook(b);
            borrow.setDateBorrow(LocalDate.now());

            LocalDate date = borrow.getDateBorrow();
            Integer nbDays = borrow.getNumberDays();
            borrow.setDateExpired(date.plusDays(nbDays));
            borrowService.saveBorrow(borrow);
        }
    }

    //-- PRIVATE METHODS --//
    private Book findBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }





}
