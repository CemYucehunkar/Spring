package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.security.AllPermission;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgresPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        //10.satırdaki kod ile bu persistencedeki ismiyle veritabanına bağlanabilirsin  izni veriyor.
        // bu veri tabanında oluşturdğumuz " market " tablosuna bağlanacak.
        // Diğer 2 kodumuzla entityManager adında bir yapı oluşturuyoruz ve artık ENTİTY olan sınıfları sistem
        //otomatik alıp işleyecek.


        //TRANSACTİON yapısı . Bizim  nesnelerimizi oluşturup özellikierini sisteme kayıt etmeyi, silmeyi,değiştirmeyi sağlar.
        // biz bir sınıfa ait nesne oluşturmak istiyorsak bu yapı içinde tanımlamalıyız özelliklerini.

//----------------------------------------------------------------------------------------
        //1) KİŞİ OLUŞTURMA VE SİSTEME YÜKLEME

      /*  transaction.begin();// begin ile commit arasında tanımlayacağız tüm kullanıcıları tek tek.
        Customer c1 = new Customer();
        c1.setName("Elif");
        c1.setEmail("elif@gmail");
        c1.setGender(Customer.GENDER.FAMELE);// cinsiyeti bu şekilde tanımlarız.
        c1.setOnDate(LocalDate.now());//ekleme tarihi şimdiki tarih olsun demek bu şekilde olur.
        entityManager.persist(c1);// veritabanı ile  bu customerı bağla diyerek veri tabanına yolluyor verileri
        transaction.commit();*/

//----------------------------------------------------------------------------------------
        //2)KİŞİYİ BULUP GETİRME VE KİŞİYİ GÜNCELLEME
        /*transaction.begin();
        Customer c2= entityManager.find(Customer.class, 1); // bu şekilde Customer sınıfından bir nesne oluşturup
        // 1. id kişiyi bulup c2 ye eşitlemesi için bu komut satırı yazılır.

        c2.setName("Cem"); // Bu şekilde direk yeni isim tanımlayabiliriz.
        entityManager.persist(c2);// Tanımlanan işlemi database yollamak için bunu yaparız.

        transaction.commit(); // Tüm bunlar begin ve commit içinde yapılmalı*/
//----------------------------------------------------------------------------------------

        //3) KİŞİYİ SİLME

      /*  transaction.begin();
        Customer c3 =entityManager.find(Customer.class,1);// Kişiyi bulup getir ve c3 e eşitle
        entityManager.remove(c3);  // c3 nesnesine tanımlı 1. id li kişiyi sil .
        transaction.commit();  */
//----------------------------------------------------------------------------------------
     transaction.begin();

       //Supplier ekleme
        Supplier supplier = new Supplier();
        supplier.setAdress("Adress");
        supplier.setCompany("Patika");
        supplier.setContact("12315");
        supplier.setMail("cem@gmail.com");
        supplier.setPerson("Cem");
        entityManager.persist(supplier);


        // Categori ekleme
        Category category=new Category();
        category.setName("phone");
        entityManager.persist(category);



        //Code ekleme
        Code code1 = new Code();
        code1.setGroup("123");
        code1.setSerial("6457");//
        entityManager.persist(code1);


        //Ürün ekleme
        Product product = new Product();
        product.setName("Samsun-A52");
        product.setPrice(1000);
        product.setStock(100);
        product.setCode(code1);
        product.setSupplier(supplier);
        product.setCategory(category);
        entityManager.persist(product);




      Color blue= new Color();
      blue.setName("Blue");
      Color yellow= new Color();
      yellow.setName("Yellow");
      Color red= new Color();
      red.setName("Red");
      entityManager.persist(blue);
      entityManager.persist(red);
      entityManager.persist(yellow);

      Product pr =entityManager.find(Product.class ,1);// product yani ürünün renklerini de eklememiz lazm.
      List<Color> colorList=new ArrayList<>();// Burda renkler birden fazla olabileceği için bir liste şeklinde veriyoruz renkleri.
      colorList.add(blue);// Bunu yapmamızın sebebi. Product oluştu her şeyini setledik. Renkkler yeni oluştu. o yüzden
      colorList.add(yellow);// şimdi ilk yaptığımız setleme işlemine ek bu sefer LİSTE setliyoruz.
      colorList.add(red);// Önce  RENKLERİ TUTAN BİR LİSTE OLUŞTUR. SONRA BU LİSTEYE RENKLER EKLE. SONRA BU LİSTEYİ
      pr.setColorList(colorList);// SONRA BU LİSTEİ PRODUCTA TANIMLA SETLE .
      entityManager.persist(pr);// SONRA DA BU VVERİYİ PUSHLA SİSTEME

      transaction.commit();


    }
}