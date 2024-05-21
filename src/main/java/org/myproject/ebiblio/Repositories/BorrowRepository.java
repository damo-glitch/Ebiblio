package org.myproject.ebiblio.Repositories;

import org.myproject.ebiblio.Entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
//    Borrow findBorrowByDate(LocalDate dateBorrow);
//
//    List<Borrow> findBorrowsByBookBetween(LocalDate startDate, LocalDate endDate);
//
//    List<Borrow> findBorrowsByBook(String title);

    List<Borrow> findByDateBorrowBetween(LocalDate startDate, LocalDate endDate);


    List<Borrow> findBorrowsByBook_Title(String title);
}
