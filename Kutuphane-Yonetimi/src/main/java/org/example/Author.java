package org.example;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    @Column(name = "author_name")
    private String name;
    @Column(name = "author_brithDate")
    private LocalDate brithDate;
    @Column(name = "author_country")
    private String country;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
