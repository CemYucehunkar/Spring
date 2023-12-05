package business.abst;

import entities.Customer;

public interface ICustomerMenager {
    boolean save(Customer customer);// Customer menager sınıfı içindeki save metodunu burada tanımlıyoruz.
}// ve Customerda bu metodu implement ediyoruz.
