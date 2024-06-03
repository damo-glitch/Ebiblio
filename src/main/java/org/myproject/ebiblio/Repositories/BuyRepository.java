package org.myproject.ebiblio.Repositories;

import org.myproject.ebiblio.Entities.Borrow;
import org.myproject.ebiblio.Entities.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {

    List<Buy> findByDateBuyBetween(LocalDate startDate, LocalDate endDate);


    List<Buy> findBuysByBook_Title(String title);
}
