package com.example.udemyjpaproject.entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    //Defining Relationships
    //Defined owning side
    @OneToOne(fetch=FetchType.LAZY)
    private Passport passport;

    //Constructors
    protected Student(){}

    public Student(String name) {
        this.name = name;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Passport Getter
    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                '}';
    }


}
