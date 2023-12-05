package dao.concretes;
import core.HibernateSession;
import dao.abstracts.ICustomerDao;
import entities.Customer;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;
//-------------------- BURADA TÜM İŞLEMLERİN VERİTABANINDA YAPILMASI İÇİN GEREKLİ KODLARI YAZIYORUZ.----
public class CustomerDao implements ICustomerDao {
    private final Session session ;// Burada final olarak session oluşturduk.

    public CustomerDao() {// Bu bizden otomatik bir boş constructor oluşturmamızı istiyor.
        this.session = HibernateSession.getSession();// Bu da oluşturdğumuz HibernateSession classından getSession metodunu çağırıp
        // Bize bunun VERİTABANINA BAĞLANMIŞ BİR SESSİON döndürmesini sağlıyor.
    }

    @Override
    public void save(Customer customer) {  //  Burada ekleme işlemini yapmak için gerekli olan kodları yazıyoruz.
        this.session.beginTransaction();  // Veritabanına ekleme işlemi begin ile commit arasında olacağı için bu şekilde bir aç kapa yapılması şart.
        this.session.persist(customer);  // Böylece veri tabanına bir ekleme işlemi yapmış oluyoruz.
        this.session.getTransaction().commit();

    }

    @Override
    public void update(Customer customer) {
        this.session.beginTransaction();
        this.session.update(customer);
        this.session.getTransaction().commit();

    }
//------------ BURADA TÜM İŞLEMLERİN VERİTABANINDA YAPILMASI İÇİN GEREKLİ KODLARI YAZIYORUZ.----------------------------------------------
    @Override
    public void delete(Customer customer) {
        this.session.beginTransaction();
        this.session.remove(customer);
        this.session.getTransaction().commit();

    }

    @Override
    public Customer findById(int id) {
       return  this.session.get(Customer.class, id);// Burada veritabanından bir id ye göre arama işlemi yapmış oluyoruz.
   // GET metodu zaten otomatik bir arama sağladığı için başka bir kod yazmamıza gerek kalmıyor.
    }

    @Override
    public List<Customer> findAll() {
        return this.session.createQuery("from Customer ").getResultList();
    }

    @Override
    public Customer findByMail(String mail) {
        SelectionQuery<Customer> query = this.session.createQuery("from Customer where mail=:mail", Customer.class);
       // Burada bir sorgu oluşturuyoruz. Bu sorgu şu şekilde olacak. Customer tablosundan maili parametre olarak
        // gelen mail e eşit olan bir kayıt varsa onu bana getir.
        query.setParameter("mail", mail );// Burada da parametre olarak gelen mail i query deki mail e eşitliyoruz.
        return  query.getSingleResultOrNull();// Burada da bu sorgunun tek bir sonuç döndürmesini sağlıyoruz.
    }
}
