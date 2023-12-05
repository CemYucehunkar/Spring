package dev.patika.LibraryApp.repository;

import dev.patika.LibraryApp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByNameAndBirthDateAndCountry(String name, LocalDate birthDate, String country);
// Burada yapılmak istenen, AuthorRepository interface'i içerisinde, Author entity'sinin name, birthDate ve country
// alanlarının birlikte bulunduğu bir kayıt olup olmadığını kontrol eden bir metot tanımlamaktır. Bu metot, Author
// entity'sinin name, birthDate ve country alanlarının birlikte bulunduğu bir kayıt varsa bu kaydı Optional olarak
// döndürecek, yoksa Optional.empty() döndürecektir. Bu metot sayesinde, Author entity'sinin name, birthDate ve
// country alanlarının birlikte bulunduğu bir kayıt olup olmadığını kontrol edebileceğiz.

    // neden Optional kullanıyoruz?
    // Optional, Java 8 ile birlikte gelen bir sınıftır. Bu sınıf, bir nesnenin null olup olmadığını kontrol etmemizi
    // sağlar. Eğer bir nesne null ise Optional.empty() döner, null değilse Optional.of(nesne) döner. Bu sayede
    // null kontrolü yapmamıza gerek kalmaz. Optional sınıfı ile ilgili daha detaylı bilgi için şu linki inceleyebilirsiniz.
    // https://www.baeldung.com/java-optional
}
