package com.hb1.manytomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student5 {

    @Id
    private int id;

    @Column(name = "std_name")
    private String name;

    @Column
    private int grade;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="Student5_Book5",
            joinColumns = {@JoinColumn(name="std_id")},
            inverseJoinColumns = {@JoinColumn(name="book_id")})
    private List<Book5> bookList = new ArrayList<>();


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

    public List<Book5> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book5> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student5{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
