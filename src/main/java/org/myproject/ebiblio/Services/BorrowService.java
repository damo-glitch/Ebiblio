package org.myproject.ebiblio.Services;

import org.myproject.ebiblio.Entities.Borrow;

import java.time.LocalDate;
import java.util.List;

public interface BorrowService {
    Borrow saveBorrow(Borrow borrow);

    List<Borrow> getAllBorrows();

    List<Borrow> getBorrowsByBookTitle(String title);

    List<Borrow> getBorrowsByDate(String startDate, String endDate);

}
