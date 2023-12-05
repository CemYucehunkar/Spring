package dev.patika.spring.business.abstracts;

import dev.patika.spring.Customer;

public interface ICustomerServis {

    Customer getById(int id);
    Customer save(Customer customer);
    void deleteById(Customer customer);// bu metot neden void çünkü silme işlemi yaparken bir şey döndürmeye gerek yok.
    Customer update(Customer customer);// bu metot neden void değil de Customer döndürüyor.
    Customer findAll();
}
