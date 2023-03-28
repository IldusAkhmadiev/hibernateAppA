package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // Подключаем проперти данные для работы с базой данных
        Configuration configuration = new Configuration(); // hibernate.properties по умолчанию передается в конструктор
        configuration.addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Person person = session.get(Person.class, 1);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        session.getTransaction().commit();
        sessionFactory.close();

    }
}
