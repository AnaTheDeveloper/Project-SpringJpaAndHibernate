package com.example.udemyjpaproject.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table - To specify the table name, as it could be different elsewhere.

@NamedQueries(value = {
        @NamedQuery(name="query_get_all_courses", query="SELECT c FROM Course c"),
        @NamedQuery(name="query_get_100_Step_courses", query="SELECT  c  FROM Course c WHERE name LIKE '%100 Steps'")
})


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
