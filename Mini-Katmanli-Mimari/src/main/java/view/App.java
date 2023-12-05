package view;

import business.concretes.CustomerMenager;
import dao.concretes.CustomerDao;
import entities.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CustomerMenager customerMenager = new CustomerMenager(new CustomerDao());

//   -----------------  EKLEME İŞLEMİNİN. ------------------
    /*    Customer customer = new Customer();
        customer.setName("Test Dersleri");
        customer.setMail("TEST@patika.dev");
        customer.setOnDate(LocalDate.now());
        customer.setGender(Customer.GENDER.MALE);


        customerMenager.save(customer);    // Kotrolü yapıldı ve ekleme işlemi başarılı

*/

//-----------------  FindByİD  Getirme İşlemi. ------------------

        //Customer firstCustomer = customerMenager.findById(1);// Kodları CustomerMenagerda yazdık burada sadece çağırdık.


 //-----------------  FİNDBYİD ile SİLME İŞLEMİ ------------------
      //  customerMenager.deleteById(2); ---> Bunu CustomerMenagerda kodlarını yazdık burada sadece çağırdık.




  //----------------- UPDATE İŞLEMİ ------------------
       /* Customer customer = customerMenager.findById(1);
        customer.setName("Test Dersleri");
        customer.setMail("patikadev@patika.dev");// bu işlemleri yaparken CustomerMenager da kodu doldurmamız lazım.
        // Kodda bazı sorguları da yapmamız lazım. Be mail adresi veya İD daha önce kullanılmış mı .
        // Kullanılmışsa hata vermesi lazım.

        customerMenager.update(customer);

        */


  //----------------- FİNDALL İŞLEMİ ------------------


        List<Customer> customerList = customerMenager.findAll();
        System.out.println(customerList.toString());

    }
}