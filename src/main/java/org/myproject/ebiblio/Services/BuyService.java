package org.myproject.ebiblio.Services;


import org.myproject.ebiblio.Entities.Buy;

import java.util.List;

public interface BuyService {

    Buy saveBuy(Buy buy);

    List<Buy> getAllBuys();

    List<Buy> getBuysByBookTitle(String title);

    List<Buy> getBuysByDate(String startDate, String endDate);

}
