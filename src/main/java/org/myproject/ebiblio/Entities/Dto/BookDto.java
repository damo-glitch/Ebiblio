package org.myproject.ebiblio.Entities.Dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Enum.BookStatus;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private UUID isbn;
    private String title;
    private String author;
    private LocalDate dateOfPublication;
    private String editor;
    private Integer InStock;
    private Double priceBuy;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
}
