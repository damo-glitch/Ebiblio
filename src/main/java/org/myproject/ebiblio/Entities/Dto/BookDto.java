package org.myproject.ebiblio.Entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private LocalDate dateOfPublication;
    private String editor;
    private Integer inStock;
    private Double priceBuy;
}
