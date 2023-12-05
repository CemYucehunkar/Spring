package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()// Başlamadan önce bir ayar dosyamız olması gerekiyor.Confing hibertane ile ilgili ayarları yapmak için kullanılır.
                .configure("hibernate.cfg.xml")// Bu ayar dosyasını kullanarak bir sessionfactory oluşturuyoruz.
                .addAnnotatedClass(Customer.class)// Burada entity classımızı ekliyoruz. Bunu eklemezsek bu config dosyasını kullanamayız.
                .buildSessionFactory();//   ve ayar dosyamız aktif oluyor.

        Session session = factory.openSession(); // Bu da JPA da ki enttiy manager yerine kodlamayı başlatmak için kullanılır.

        session.beginTransaction();
        try {
           Customer customer = new Customer();
            /*  customer.setName("Mehmet");
            customer.setEmail("mail.@gmail.com");
            customer.setOnDate(LocalDate.now());
            customer.setGender(Customer.GENDER.FAMALE);

            session.persist(customer);*/

         /*   customer = session.get(Customer.class, 1);// Burada veri tabanından veri çekiyoruz.
            customer.setName("Cem");// Çektiğimiz veriyi güncelliyoruz.
            session.persist(customer);// Güncellenen veriyi veri tabanına kaydediyoruz.*/


         //   session.remove(session.get(Customer.class, 1));// Burada veri tabanından 1 nolu veri çekiyoruz ve silme işlemi yapıyoruz.


         //  List<Customer> customers= session.createQuery("from Customer", Customer.class).getResultList();// Burada customer tablosundaki tüm  verileri çekiyoruz ve liste halinde bastırıyoruz.

          Customer customer1=session.createSelectionQuery("from Customer where id = 2", Customer.class).getSingleResultOrNull();  // Burada customer tablosundaki id si 2 olan veriyi çekiyoruz  bastırıyoruz.

            session.getTransaction().commit();

         //   BURYA DAHA JPQL SORGULARI YAZILACAK. 11.  HAFTANIN 1. VİDEOSUNU BİR DAHA İZLE NOT AL.


        } catch (Exception e) {
            session.getTransaction().rollback();// Hata olursa işlemi geri alır.
            e.printStackTrace();// Hata mesajını gösterir.


        } finally {
            session.close();
        }


    }
}
