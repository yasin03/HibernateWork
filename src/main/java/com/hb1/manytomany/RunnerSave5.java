package com.hb1.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave5 {
    public static void main(String[] args) {

        Book5 bookArt = new Book5();
        Book5 bookMath = new Book5();

        Student5 student1 = new Student5();
        Student5 student2 = new Student5();
        Student5 student3 = new Student5();

        student1.setId(1001);
        student1.setName("Walter White");
        student1.setGrade(65);
        student1.getBookList().add(bookArt);
        student1.getBookList().add(bookMath);

        student2.setId(1002);
        student2.setName("Maximus Decimus");
        student2.setGrade(80);
        student2.getBookList().add(bookArt);
        student2.getBookList().add(bookMath);

        student3.setId(1003);
        student3.setName("John Coffee");
        student3.setGrade(78);
        student3.getBookList().add(bookArt);
        student3.getBookList().add(bookMath);

        bookArt.setId(101);
        bookArt.setName("Art Book");


        bookMath.setId(102);
        bookMath.setName("Math Book");



        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student5.class).addAnnotatedClass(Book5.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();








        session.save(student1);
        session.save(student2);
        session.save(student3);




        tx.commit();
        sf.close();
        session.close();


    }
}
