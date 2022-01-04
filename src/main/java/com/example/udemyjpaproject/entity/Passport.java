package com.example.udemyjpaproject.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    //This clashes with the owning side, so we specify which side is the owning side. private Passport passport; in Student. passport is the name.
    //Adding mappedBy on the noon-owning side of the relationship
    @OneToOne(fetch=FetchType.LAZY, mappedBy = "passport")
    private Student student;

    protected Passport(){}

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "name='" + number + '\'' +
                '}';
    }
}
