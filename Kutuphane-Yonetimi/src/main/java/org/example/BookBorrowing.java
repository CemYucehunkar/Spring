package org.example;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_borrowing")

public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String borrowingName;
    @Column(name = "borrowing_date")
    private LocalDate borrowingDate;
    @Column(name = "retun_date")
    private LocalDate retunDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

}
