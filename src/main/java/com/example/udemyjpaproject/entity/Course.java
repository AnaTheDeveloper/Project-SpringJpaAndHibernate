package com.example.udemyjpaproject.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
//@Table - To specify the table name, as it could be different elsewhere.
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(name="exampleName"), nullable=false - Specify table columns and that it can't be null.
    @Column(nullable = false)
    private String name;

    //Hibernate Annotations

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;


    //No Argument Constructor
    protected Course(){}

    public Course(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
