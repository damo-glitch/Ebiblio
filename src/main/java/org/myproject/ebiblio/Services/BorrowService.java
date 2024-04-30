package org.myproject.ebiblio.Services;

import org.myproject.ebiblio.Entities.Borrow;

import java.util.List;

public interface BorrowService {
    Borrow saveBorrow(Borrow borrow);

    Borrow updateBorrow(Borrow borrow);

    Borrow deleteBorrow(Borrow borrow);

    List<Borrow> getAllBorrows();
}
