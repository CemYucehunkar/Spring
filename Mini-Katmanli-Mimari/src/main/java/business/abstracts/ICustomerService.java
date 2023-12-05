package business.abstracts;

import entities.Customer;

import java.util.List;

public interface ICustomerService {  // Buraları concretes de CustomerServices de  dolduracağız.
    void save(Customer customer);// Ekleme işlemi yapabilsin

    void update(Customer customer);// Güncelleme işlemi yapabilsin

    void deleteById(int id);// id ye göre Silme işlemi yapabilsin


    Customer findById(int id);// id ye göre arama işlemi yapabilsin

    List<Customer> findAll();// Tüm kayıtları getirsin
}
