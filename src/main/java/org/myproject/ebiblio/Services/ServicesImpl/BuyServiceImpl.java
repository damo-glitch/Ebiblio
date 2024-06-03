package org.myproject.ebiblio.Services.ServicesImpl;

import org.myproject.ebiblio.Entities.Buy;
import org.myproject.ebiblio.Repositories.BuyRepository;
import org.myproject.ebiblio.Services.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BuyServiceImpl implements BuyService {


    @Autowired
    private BuyRepository buyRepository;

    /**
     * Cette méthode permet de sauvegarder de l'achat de livre
     * @param buy
     * @return buy
     */
    @Override
    public Buy saveBuy(Buy buy) {
        return buyRepository.save(buy);
    }

    /**
     * Cette méthode permet de récuperer tous les achats de livre
     * @return List<Buy>
     */
    @Override
    public List<Buy> getAllBuys() {
        return buyRepository.findAll();
    }

    /**
     * Cette méthode permet de rechercher tous les achats de livre par son titre
     * @param title
     * @return List<Buy>
     */
    @Override
    public List<Buy> getBuysByBookTitle(String title) {
        return buyRepository.findBuysByBook_Title(title);
    }

    /**
     * Cette méthode permet de rechercher tous les achats de livre par date
     * @param startDate
     * @param endDate
     * @return List<Buy>
     */
    @Override
    public List<Buy> getBuysByDate(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return buyRepository.findByDateBuyBetween(start, end);
    }
}
