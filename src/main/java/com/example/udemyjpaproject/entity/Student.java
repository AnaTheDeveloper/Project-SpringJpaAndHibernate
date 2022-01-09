package com.example.udemyjpaproject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    /*
    We used embedded to take the values from another object and directly store them as part of the current entity.
     */
    private Address address;

    //Defining Relationships
    //Defined owning side
    @OneToOne(fetch=FetchType.LAZY)
    private Passport passport;

    @ManyToMany
    @JoinTable(name="STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID")) //Add join table customization
    private List<Course> courses = new ArrayList<>();


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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //Passport Getter
    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    //Course getters and setters


    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course courses) {
        this.courses.add(courses);
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                '}';
    }


}
