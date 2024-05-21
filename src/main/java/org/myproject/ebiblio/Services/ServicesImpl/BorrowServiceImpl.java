package org.myproject.ebiblio.Services.ServicesImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Borrow;
import org.myproject.ebiblio.Repositories.BorrowRepository;
import org.myproject.ebiblio.Services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow updateBorrow(Borrow borrow) {
        return null;
    }

    @Override
    public Borrow deleteBorrow(Borrow borrow) {
        return null;
    }

    @Override
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }
}
