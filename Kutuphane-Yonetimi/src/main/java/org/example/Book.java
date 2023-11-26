package org.example;


import jakarta.persistence.*;
import lombok.*;

import javax.swing.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "book_name", nullable = false)
    private String name;
    @Column(name = "publication_year")
    private int publicationYear;
    @Column(name = "stock")
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autohor_id")
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "bookcat",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> bookcat;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "book_borrowing_id")
    private List<BookBorrowing> bookBorrowingList;


}
