package org.myproject.ebiblio.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private LocalDate dateOfPublication;
    private String editor;
    private Integer inStock;
    private Double priceBuy;


    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;
}
