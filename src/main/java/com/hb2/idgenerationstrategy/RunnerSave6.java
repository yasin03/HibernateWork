package com.hb2.idgenerationstrategy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave6 {

    public static void main(String[] args) {

        Student6 student1=new Student6();
        student1.setName("John Coffee");
        student1.setGrade(100);

        Student6 student2=new Student6();
        student2.setName("Walter White");
        student2.setGrade(85);

        Student6 student3=new Student6();
        student3.setName("Maximus Decimus");
        student3.setGrade(65);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student6.class);
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
