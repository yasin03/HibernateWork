package com.hb4.first_second_levelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {

        Student08 student = new Student08();
        Student08 student2 = new Student08();

        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx= session.beginTransaction();

        //First Level cache 1.senaryo:aynı session içinde aynı id ile fetch yapıldığında

//		student1= session.get(Student08.class, 1L);
//
//		System.out.println("----------------------");
//
//		System.out.println(student1);
//
//		//eğer first level chache temizlemek istersek session.clear ile yapılabilir.
//		//session.clear();
//
//		System.out.println("----------------------");
//		student1= session.get(Student08.class, 1L);
//
//		System.out.println("----------------------");
//		System.out.println(student1);


        //First Level Cache 2.senaryo: aynı session içinde farklı id ile fetch yapıldığında

//		student1= session.get(Student08.class, 1L);
//
//		System.out.println("----------------------");
//
//		System.out.println(student1);
//
//		System.out.println("----------------------");
//		student1= session.get(Student08.class, 2L);
//
//		System.out.println("----------------------");
//		System.out.println(student1);
//
//
//
//
//		tx.commit();
//		session.close();



        //2.level cache 1. senaryo:


        student=session.get(Student08.class, 1L);
        System.out.println(student);
        tx.commit();
        session.close();



        //2.session
        Session session2=sf.openSession();
        Transaction  tx2= session2.beginTransaction();

        student2=session2.get(Student08.class, 1L);
        System.out.println(student2);

        tx2.commit();
        session2.close();



        sf.close();

    }
}
