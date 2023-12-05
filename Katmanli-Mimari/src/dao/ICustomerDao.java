package dao;

import entities.Customer;

//------------------Dependency Injection------------------
public interface ICustomerDao {  // Bunu oluşturmamızın amacı. Bizim olası bir veritabanı bağlanma yöntemi değiştirmemizde
    // gelecek yeni bağlantı Bu interface den implement edilince burada belirtilen metodları kullanmasında bir sorun olmayacak.
public boolean saveCustomer(Customer customer);

public Customer getıd(Customer customer);
}// Burada Sadece metodların imzası var. Yani metodların dönüş tipi ve parametreleri var. İçi boş olacak.
// Bu interface i implement eden sınıfların içinde bu metodların içi doldurulacak.

// şimdi Customer Menafar sınıfına gidip devam edelim.