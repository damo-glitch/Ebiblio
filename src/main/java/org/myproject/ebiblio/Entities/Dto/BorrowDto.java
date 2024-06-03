package org.myproject.ebiblio.Entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDto {
    private Long id;
    private LocalDate dateBorrow;
    private Integer quantity;
    private Integer numberDays;
    private LocalDate dateExpired;
    private BookDto book;
    //private User user;
}
