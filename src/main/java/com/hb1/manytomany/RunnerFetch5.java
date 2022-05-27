package com.hb1.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

public class RunnerFetch5 {
    public static void main(String[] args) {
        Student5 student = new Student5();
        Book5 book = new Book5();


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student5.class).addAnnotatedClass(Book5.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /*
        student = session.get(Student5.class,1001);
        System.out.println(student.getName() + "-----------"+student.getBookList());
        */

        /*
        book = session.get(Book5.class,101);
        System.out.println(book);
        */

        /*
        // HQL İLE KİTAP İSMİNE GÖRE KAYIT GETİRME VE KİTAP SAHİPLERİNİ GÖRME

        String hql1= " FROM Book5 b WHERE b.name='Math Book'";
        book = (Book5) session.createQuery(hql1).getSingleResult();
        System.out.println(book.getName() + " - " + book.getStudents().size());
        book.getStudents().forEach(System.out::println);
        */

        /*
        String hql2 = "FROM Student5 s WHERE s.name = 'John Coffee'";
        student = (Student5) session.createQuery(hql2).getSingleResult();
        student.getBookList().forEach(t-> System.out.println(t));
        */

        /*
        String hql3 = "SELECT s.name FROM Student5 s";
        List<Object []> resultList = session.createQuery(hql3).list();
        resultList.forEach(System.out::println);
        */

        String hql4 = "SELECT s.name FROM Student5 s INNER JOIN FETCH Book5 b ON s.id = 1001";
        List resultList = session.createQuery(hql4).getResultList();
        resultList.stream().forEach(System.out::println);



        /*
        String qry1 ="select * from Student5";
        List<Object []> result1 = session.createSQLQuery(qry1).getResultList();

        for (Object [] o : result1) {
            System.out.println(Arrays.toString(o));
        }
        */


        tx.commit();
        sf.close();
        session.close();




    }
}
