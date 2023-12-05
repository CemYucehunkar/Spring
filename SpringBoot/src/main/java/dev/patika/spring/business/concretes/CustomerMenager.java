package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.ICustomerServis;
import dev.patika.spring.dao.CustomerRepo;
import dev.patika.spring.Customer;
import org.springframework.stereotype.Service;

@Service // bunun bir servis yani business katmanı olduğunu belirtiyoruz.
public class CustomerMenager implements ICustomerServis {
    private  final CustomerRepo customerRepo;  // Repomuza bağlantımızı da bu şekilde kuruyoruz.
        public CustomerMenager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
// şimdi burası ütünden bir servis yazacağız.
    @Override
    public Customer getById(int id) {
        return this.customerRepo.findById(id).orElseThrow();// Buna 8.satırda REPOMUZU tanımladığımız için ulaşabiliyoruz.
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public void deleteById(Customer customer) {
        this.customerRepo.delete(customer);
    }

    @Override
    public Customer update(Customer customer) {
            if (customer.getId() == 0)
                throw new RuntimeException("Lütfen id değeri olan bir entity giriniz.   ");
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer findAll() {
        return null;
    }
}
