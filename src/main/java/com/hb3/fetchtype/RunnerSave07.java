package com.hb3.fetchtype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Book07 book1=new Book07();
        Book07 book2=new Book07();
        Book07 book3=new Book07();
        Book07 book4=new Book07();

        Student07 student1=new Student07();
        Student07 student2=new Student07();
        Student07 student3=new Student07();

        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(100);

        student2.setId(1002);
        student2.setName("Walter White");
        student2.setGrade(86);

        student3.setId(1003);
        student3.setName("Maximus Decimus");
        student3.setGrade(95);


        book1.setId(101);
        book1.setName(student1.getName()+"' science book");
        book1.setStudent(student1);

        book2.setId(102);
        book2.setName(student1.getName()+"' art book");
        book2.setStudent(student1);

        book3.setId(103);
        book3.setName(student2.getName()+"'math book");
        book3.setStudent(student2);

        book4.setId(104);
        book4.setName("No body's book");


        student1.getBookList().add(book1);
        student1.getBookList().add(book2);
        student1.getBookList().add(book4);

        student2.getBookList().add(book3);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
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
