package com.hb2.idgenerationstrategy;

import javax.persistence.*;

@Entity
public class Student6 {

    // @GeneratedValue tek başına kullanılırsa default AUTO strategy seçilir.
    // GenerationType.IDENTITY en kolay id oluşturma yöntemidir. Performans olarak en iyi değildir.
    // veritabanındaki auto increment olayına göre çalışır.
    // @GeneratedValue(strategy = GenerationType.IDENTITY)

    // GenerationType.SEQUENCE performansı daha yüksek. toplu insert işlemlerinde SEQUENCE daha performanslı
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STD_SEQ")
    // @SequenceGenerator(name="STD_SEQ", initialValue = 1000, allocationSize = 50)

    // 8-4-4-4-12 128bit 32 characters id oluşturuyor
    //  @GeneratedValue(generator = "UUID")
    //  @GenericGenerator(name="UUID", strategy = "uuid2")
    //  private String id;

    // Performansı düşük, Bir tablo oluşturup son id'yi orada tutuyor.
    // @GeneratedValue(strategy = GenerationType.TABLE)

    // Hibernate strategy olarak auto seçince strategy olarak SEQUENCE kullandı.
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "STD_SEQ")
    @SequenceGenerator(name = "STD_SEQ", initialValue = 1000, allocationSize = 50)
    private int id;

    @Column
    private String name;

    @Column
    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student6{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
