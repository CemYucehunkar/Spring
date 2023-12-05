package dao.abstracts;

import entities.Customer;

import java.util.List;

public interface ICustomerDao {
    void save(Customer customer);// Ekleme işlemi yapabilsin

    void update(Customer customer);// Güncelleme işlemi yapabilsin

    void delete(Customer customer);// id ye göre Silme işlemi yapabilsin


    Customer findById(int id);// id ye göre arama işlemi yapabilsin

    List<Customer> findAll();// Tüm kayıtları getirsin

    Customer findByMail(String mail);// Mail e göre arama işlemi yapabilsin
}
