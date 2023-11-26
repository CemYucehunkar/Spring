package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity//1. Yapılması gereken Entity anatasyonun eklemek
@Table(name = "customers")//2. olarak burada bu entityinin veri tabanındaki tablo adını oluşturuyoruz.
//eğer bunu vermezsek de class adı olan org.example.Customer otomatik oluşacaktır ama bu şekilde isim verebiliriz.
public class Customer {
    @Id// 3. olarak bu şekilde bu customerlerin bir  id tanımlıyoruz.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// Bu de verilen İD nin nasıl bir yapısı olacağını tanımlar. BENZERSİZ KİMLİK olsun bu İD ler demek için yaparız


    @Column(name = "customer_id", columnDefinition = "serial")
// COLUMN ile sütun adı verip idlerin hangi sütunda olacağını belirleriz
    // serial tanımlamasıyla bu id ler oto iplement olur böylece. Yani otomatik artar.
    private int id;


    @Column(name = "customer_name", length = 100, nullable = false)
// sütun adı customer name, uzunluğu 100 olsun ve boş olmasın
    private String name;


    @Column(name = "customer_mail", length = 100, unique = true, nullable = false)
// unıq seçmemiz bu mail ile başka kimse kayıt olamasn diye
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_date ")// Tarih verirken böyle verilecek database e temporal type  tanımlamamız lazm.
    private LocalDate onDate;// türünü de LocalDate seçmemiz lazm.

    @Enumerated(EnumType.STRING)// Bunun bir enum olduğunu ve Veritabanında karşılığı da STRİNG diye tanımlamamız gerekiyor
    @Column(name = "customer_gender")
    private GENDER Gender;

    public enum GENDER {// BU şekilde bir enum tanımlıyoruz. sonra bu enumu bir değişkene atıyoruz yukarda olduğu gibi
        MALE,
        FAMELE,
    }

    public Customer() {} // BİR TANE BOŞ CONSTRUCTION OLLUŞTUR VE GET SET METOTLARINI MUTLAKA TANIMLA

    //---> Bu şekilde bir sınıf oluşturup bu sınıfa ait nesneler üretebileceğiz. Şimdi üretmek için MAİN sınıfımıza gidelim.

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public GENDER getGender() {
        return Gender;
    }

    public void setGender(GENDER gender) {
        Gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
