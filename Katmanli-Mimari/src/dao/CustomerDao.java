package dao;

import entities.Customer;

public class CustomerDao  implements ICustomerDao{// Bunu oluşturmamızın amacı. Bizim olası bir veritabanı bağlanma yöntemi değiştirmemizde
    // gelecek yeni bağlantı Bu interface den implement edilince burada belirtilen metodları kullanmasında bir sorun olmayacak.

    // Veri tabanına kaydetme işlemleri burada yapılacak.
    public boolean saveCustomer (Customer customer){
        System.out.println("Dao JDBC katmanı çalıştı");
        System.out.println("Customer veri tabanına eklendi");
        return true;
        // Burası verilerin sisteme kaydolduğu yerdir ve burayla app arasında doğrudan bir ilişki yoktur.
        // Bu ilişkinin kurulduu yer ise business katmanıdır. Yani Customer Menager sınıfıdır.

        // Burası bu haliyle hava duruyor bununla CUSTOMER MANAGER sınıfını bağlamamız gerek.
        // Bunu gidip onun içinde bir nesne olarak tanımlıyoruz.
    }
    public Customer getıd(Customer customer){
        System.out.println("Dao Katmanı Çalıştı");
        return customer;
    }
}
