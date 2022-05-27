package com.hb3.fetchtype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchRunner07 {
    public static void main(String[] args) {

        //		FETCHTYPE=EAGER
// İlişkide olan bütün objeleri getiriyor.
//	    select
//        student07x0_.id as id1_1_0_,
//        student07x0_.grade as grade2_1_0_,
//        student07x0_.std_name as std_name3_1_0_,
//        booklist1_.student_id as student_3_0_1_,
//        booklist1_.id as id1_0_1_,
//        booklist1_.id as id1_0_2_,
//        booklist1_.name as name2_0_2_,
//        booklist1_.student_id as student_3_0_2_
//    from
//        Student07 student07x0_
//    left outer join
//        Book07 booklist1_
//            on student07x0_.id=booklist1_.student_id
//    where
//        student07x0_.id=?

//FETCHTYPE=LAZY
// İlişkili objeler getirilmedi.
//		   select
//	        student07x0_.id as id1_1_0_,
//	        student07x0_.grade as grade2_1_0_,
//	        student07x0_.std_name as std_name3_1_0_
//	    from
//	        Student07 student07x0_
//	    where
//	        student07x0_.id=?


        // Advantange of LAZY:
        // ilk yükleme zamanı daha kısadır.
        // Daha az kaynak (memory,cpu) kullanır.

        // Disadvantage of LAZY:
        // Bağlantılı objeler gelen obje içinde olmadığı için Clienttan gelen istek sayısı artabilir.


        // Advantage of EAGER
        // İstek sayısı daha az olabilir.

        // Disadvantage of EAGER
        // İlk yükleme süresi daha uzundur.
        // Kaynak kullanımı daha yüksektir.eager kullanımında ihtiyaç duyulmayan ilişkiler verilerde
        // geleceğinde Kullanırken dikkatli olunmalı aksi halde memory problemlerine yol açabilir.

        // OneToOne-Hibernate default EAGER yapar.
        // ManyToOne-Hibernate default EAGER yapar.

        // OneToMany- Hibernate default LAZY yapar.
        // ManyToMany- Hibernate default LAZY yapar.

        // FETCHTYPE LAZY ise session kapandıktan sonra ilişkili objeleri (getBookList gibi) fetch edersem
        // LazyInitializationException alırız.



        Student07 student = new Student07();

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        student = session.get(Student07.class,1001);
        System.out.println(student);




        tx.commit();
        sf.close();
        session.close();

    }
}
