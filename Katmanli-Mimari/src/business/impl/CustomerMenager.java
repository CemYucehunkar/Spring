package business.impl;

import business.abst.ICustomerMenager;
import dao.ICustomerDao;
import entities.Customer;

public class CustomerMenager implements ICustomerMenager {

    //------------------Dependency Injection------------------
  private final ICustomerDao customerDao; // Buunu bu şekilde değiştirilmesin diye final yaptık.
    // Bu nesneyi hangi veritabanı bağlantı yapısı kullanacaksa Giriş kısmında yani APP de tanımlayarak bağlantıyı 1 satır koda
    // kadar indirmiş oluyoruz.
    public CustomerMenager(ICustomerDao customerDao) {
        this.customerDao = customerDao; // AP içinde  buradaki işlemleri yapacağımız neysenye gidip yeni bağlantımızı tanımlıyoruz
    }
    // Bu sınıfın içinde bir nesne olarak tanımlıyoruz. Veee
    // aşağıdaki metot sağlandığı sürece bu nesne ile işlem yapacağız. RETURN e bunu tanımlıyoruz o yüzden

    public boolean save(Customer customer) {
        // Sorguların yapıldığı kodlar burada olacak.
        // Bu mail adresi daha önce kayıt edilmiş mi? vs diye
        System.out.println("business katmanı çalıştı ");
        return this.customerDao.saveCustomer(customer);
    }


}
