package business.concretes;

import business.abstracts.ICustomerService;
import dao.abstracts.ICustomerDao;
import entities.Customer;

import java.util.List;

public class CustomerMenager implements ICustomerService {

    private final ICustomerDao customerDao;// Burada bir DEPENDCY INJECTION yapıyoruz. Yani bir bağımlılık enjeksiyonu yapıyoruz.
    public CustomerMenager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) { // kontrolu bu  katmanda yapıyoruz.
        Customer chekMailCustomer= this.customerDao.findByMail(customer.getMail());
        // Sorguyu dao katmanında yazdığımız için burada sadece çağırıyoruz.
        // Customerlar içinde chekmailcustomer yapcam diyip. Bunu da dao katmanında yazdığımız findByMail metoduyla sağlıyoruz
        if(chekMailCustomer != null){// sonra da eğer böyle bir kayıt varsa buna hata vermesi için aşağıdaki kodu yazıyoruz
            throw new RuntimeException(customer.getMail() + " Bu mail adresi zaten kayıtlıdır.");

        }
        // Böyle bir kayıt yoksa da aşağıdaki kodu yazıyoruz. ve ekleme işlemini yapıyoruz.
        this.customerDao.save(customer);

    }

    @Override
    public void update(Customer customer) {
        Customer chekMailCustomer= this.customerDao.findByMail(customer.getMail());
        if (chekMailCustomer != null && chekMailCustomer.getId() != customer.getId()){
            throw new RuntimeException(customer.getMail() + " Bu mail adresi zaten kayıtlıdır.");

        }
        this.customerDao.update(customer);
    }

    @Override
    public void deleteById(int id) {
        Customer customer = this.findById(id);
        this.customerDao.delete(customer);

    }

    @Override
    public Customer findById(int id) {
        return this.customerDao.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDao.findAll();
    }
}
