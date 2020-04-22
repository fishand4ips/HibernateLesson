package com.alexanderkomegunov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)
                .buildSessionFactory();

        Session session = null;

        // === create ===
//        session =  sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        User user = new User("Sasok", "Komeg");
//        System.out.println(user);
//        session.save(user);
//        System.out.println(user);
//        session.getTransaction().commit();

        // === read ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        User userFromDB = session.get(User.class,1);
//        System.out.println(userFromDB);
//        session.getTransaction().commit();

        // === update ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        User userFromDB = session.get(User.class,1);
//        System.out.println(userFromDB);
//        userFromDB.setFirst_name("Alesha");
//        userFromDB.setLast_name("Neizvestnui");
//        session.getTransaction().commit();

        // === delete ===
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        User userFromDB = session.get(User.class,4);
//        session.remove(userFromDB);
//        session.getTransaction().commit();

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("select i from User i", User.class).getResultList();
        List<UserDetails> usersDetails = session.createQuery("select i from UserDetails i", UserDetails.class).getResultList();
        System.out.println(users);
        System.out.println(usersDetails);
        session.getTransaction().commit();

        sessionFactory.close();
    }
}
