package org.myproject.ebiblio.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myproject.ebiblio.Entities.Enum.BookStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID isbn;
    private String title;
    private String author;
    private LocalDate dateOfPublication;
    private String editor;
    private Integer InStock;
    private Double priceBuy;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;
}
