package org.myproject.ebiblio.Entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyDto {
    private Long id;
    private Integer quantity;
    private LocalDate dateBuy;
    private Double priceBuy;
    private BookDto book;
    //private UserDto user;
}
