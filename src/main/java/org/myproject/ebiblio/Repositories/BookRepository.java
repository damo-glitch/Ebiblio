package org.myproject.ebiblio.Repositories;

import org.myproject.ebiblio.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //Book getBookByIsbn(UUID isbn);

    Book getBookByTitle(String title);
}
