package org.myproject.ebiblio.Services.ServicesImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Book;
import org.myproject.ebiblio.Entities.Enum.BookStatus;
import org.myproject.ebiblio.Repositories.BookRepository;
import org.myproject.ebiblio.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @return
     */
    @Override
    public Book updateBook(Book book) {
        if(!bookRepository.existsById(book.getId())){
            throw new RuntimeException("Ce livre n'existe pas");
        }
        return bookRepository.save(book);
    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void deleteBoodById(Long id) {
        bookRepository.deleteById(id);
    }


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

    @Override
    public Book reverseBook(Book book) {
        return null;
    }


    private Book findBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }





}
