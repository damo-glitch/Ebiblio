package org.myproject.ebiblio.Services.ServicesImpl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Borrow;
import org.myproject.ebiblio.Repositories.BorrowRepository;
import org.myproject.ebiblio.Services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    /**
     * Cette méthode permet de sauvegarder de l'emprunt d'un livre
     * @param borrow
     * @return borrow
     */
    @Override
    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    /**
     * Cette méthode permet de recuperer tous les livres empruntés
     * @return List<Borrow>
     */
    @Override
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    /**
     * Cette méthode permet de rechercher tous les livres empruntés par son titre
     * @param title
     * @return List<Borrow>
     */
    @Override
    public List<Borrow> getBorrowsByBookTitle(String title) {
        return borrowRepository.findBorrowsByBook_Title(title);
    }

    /**
     * Cette méthode permet de rechercher tous les livres empruntés par date
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<Borrow> getBorrowsByDate(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return borrowRepository.findByDateBorrowBetween(start, end);
    }
}
