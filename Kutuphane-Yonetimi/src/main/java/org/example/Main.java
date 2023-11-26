package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgresPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Book book = new Book();
        book.setName("Kürk Mantolu Madonna");
        book.setPublicationYear(1943);
        book.setStock(100);
        book.setAuthor(entityManager.find(Author.class, 1));
        book.setPublisher(entityManager.find(Publisher.class, 1));
        entityManager.persist(book);


        Book book2 = new Book();
        book2.setName("İçimizdeki Şeytan");
        book2.setPublicationYear(1940);
        book2.setStock(120);

        book2.setAuthor(entityManager.find(Author.class, 2));
        book2.setPublisher(entityManager.find(Publisher.class, 1));
        entityManager.persist(book2);


        Author author = new Author();
        author.setName("Sabahattin Ali");
        author.setCountry("Turkey");
        author.setBrithDate(java.time.LocalDate.of(1907, 2, 25));
        entityManager.persist(author);
        Author author1 = new Author();
        author1.setName("Fyodor Dostoyevski");
        author1.setCountry("Russia");
        author1.setBrithDate(java.time.LocalDate.of(1821, 11, 11));
        entityManager.persist(author1);


        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowingName("Ahmet");
        bookBorrowing.setBorrowingDate(java.time.LocalDate.of(2023, 10, 10));
        bookBorrowing.setRetunDate(java.time.LocalDate.of(2023, 10, 20));
        entityManager.persist(bookBorrowing);
        BookBorrowing bookBorrowing2 = new BookBorrowing();
        bookBorrowing2.setBorrowingName("Mehmet");
        bookBorrowing2.setBorrowingDate(java.time.LocalDate.of(2023, 10, 23));
        bookBorrowing2.setRetunDate(java.time.LocalDate.of(2023, 10, 30));
        entityManager.persist(bookBorrowing2);


        Publisher publisher = new Publisher();
        publisher.setName("Yapı Kredi Yayınları");
        publisher.setAdress("İstanbul");
        publisher.setEstablishmentYear("1943");
        entityManager.persist(publisher);
        Publisher publisher1 = new Publisher();
        publisher1.setName("Can Yayınları");
        publisher1.setAdress("İstanbul");
        publisher1.setEstablishmentYear("1973");
        entityManager.persist(publisher1);

        Category roman = new Category();
        roman.setName("Roman");
        roman.setDescription("Roman");
        Category edebiyat = new Category();
        roman.setDescription("Edebiyat");
        edebiyat.setName("Edebiyat");
        Category turkedebiyati = new Category();
        turkedebiyati.setName("Türk Edebiyatı");
        turkedebiyati.setDescription("Türk Edebiyatı");
        Category klasik = new Category();
        klasik.setName("Klasik");
        klasik.setDescription("Klasik");
        entityManager.persist(roman);
        entityManager.persist(edebiyat);
        entityManager.persist(turkedebiyati);
        entityManager.persist(klasik);

       /* Book bookcat=entityManager.find(Book.class,book.getId());
        List<Category> categoryList=new ArrayList<>();
        categoryList.add(klasik);
        categoryList.add(edebiyat);
        bookcat.setCategory(categoryList);
        entityManager.persist(bookcat);*/

        transaction.commit();
    }

}