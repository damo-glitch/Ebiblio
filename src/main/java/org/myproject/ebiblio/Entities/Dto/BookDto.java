package org.myproject.ebiblio.Entities.Dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Enum.BookStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String isbn;
    private String title;
    private String author;
    private LocalDate dateOfPublication;
    private String editor;
    private Integer inStock;
    private Double priceBuy;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
}
