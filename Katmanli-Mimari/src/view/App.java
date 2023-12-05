package view;

import business.impl.CustomerMenager;
import dao.CustomerHibernateDao;
import entities.Customer;

public class App {
    public static void main(String[] args) {

        Customer customer=new Customer();
        customer.setName("Cem");
        customer.setMail("cem@gmail.com");

        System.out.println("Veri girişi oldu");

        CustomerMenager customerMenager=new CustomerMenager(new CustomerHibernateDao());// CustomerMenager sınıfı içindeki
        // bağlantısı nesnesini burada tanımlıyoruz. Artık Bu nesne ile işlem yapacağız.
        // Olası bir veritabanı değişikliğinde burada new CustomerHibernateDao() kısmını değiştirmemiz yetecek.
        customerMenager.save(customer);
    }
}
