package core;

import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {//
    public static Session session = null;// Burada static bir session oluşturduk.

    public static Session getSession() {//getSession metodunu oluşturmamızın sebebini şöyle açıklayabiliriz.
        // HibernateSession.getSession() şeklinde çağırıp kullanmak için.
        if (session == null) { //Eğer yeni bir sessin oluşmamışsa bu bloğa gir.
            SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class)
                    .buildSessionFactory();


            session = factory.openSession();//sessionu açtık.
        }
        return session;
    }
}
