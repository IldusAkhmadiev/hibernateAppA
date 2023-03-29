package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App  {
    static Configuration configuration = null; // hibernate.properties по умолчанию передается в конструктор
    static SessionFactory sessionFactory = null;
    static {
        configuration = new Configuration();
        configuration.addAnnotatedClass(Person.class);
        sessionFactory = configuration.buildSessionFactory();
    }


    public static void main( String[] args )
    {

        System.out.println(savePerson());
//        System.out.println(updatePerson());
    }

    public static Person savePerson()  {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Person person = new Person("Ali",33);
        session.save(person);
        System.out.println(person.getId());
        session.getTransaction().commit();
        sessionFactory.close();
        return person;
    }

    public static Person updatePerson() {
        Person person = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            person = session.get(Person.class, 2);
            person.setName("Mua");
//            person.setId(15);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
        return person;
    }

    public static Person deletePerson() {
        Person person = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            person = session.get(Person.class, 2);
            session.delete(person);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
        return person;
    }
}
