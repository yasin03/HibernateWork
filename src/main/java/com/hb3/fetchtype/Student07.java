package com.hb3.fetchtype;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {

    @Id
    private int id;
    // length:max karakter sayısını
    // nullable: ilgili kolonun null olup olmayacağını belirler. true yada false
    // olabilir
    // unique: Unique olması istenen alanlar bu attribute ile belirlenir. true ya da
    // false olabilir.
    // updatable: update edilebilir şekilde yarlamak için kullanılır.true yada false
    // alabilir. Default true
    // insertable: burasıda insert edilebilir değer yarlanabilir. true yada false
    // alabilir. Default true

    @Column(name = "std_name", length = 100, nullable = false, unique = true)
    private String name;

    private int grade;


    @OneToMany(mappedBy ="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book07> bookList = new ArrayList<>();
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
    public List<Book07> getBookList() {
        return bookList;
    }
    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }
    @Override
    public String toString() {
        return "Student07 [id=" + id + ", name=" + name + ", grade=" + grade + ", bookList=" + bookList + "]";
    }
}
