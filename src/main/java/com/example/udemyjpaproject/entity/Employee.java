package com.example.udemyjpaproject.entity;

import javax.persistence.*;

@MappedSuperclass //When something is a MappedSuperclass it cannot be an @Entity at the same time.

//@Entity

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Default strategy used
//@DiscriminatorColumn(name = "Employee_Type") //Name the DTYPE column name (represents the sub-classes of the super)

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //Individual tables made when data is inserted

//@Inheritance(strategy = InheritanceType.JOINED)
/*Fields tha are specific to a subclass are mapped to a separate table then the fields
that are common to the parent class and a join is performed to instantiate the subclass.
 */

/*

NOTES:

The problem with single table hierarchy is that you will have a lot of nullable columns. But you are getting the details from a single table(no use of joins). Good performance but poor integrity

When you use TABLE_PER_CLASS each concrete subclass is provided with an individual table. But common columns will be repeated in both table columns. Does not meet 3rd normal form.

JOINED creates foreign keys in the new tables, but it has to combine multiple table and that could affect the performance. Good data integrity. Values only appear once. No null values

In @MappedSuperclass the details are stored in different tables. This way does not use inheritance.
 */

public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    protected Employee() {
    }

    public Employee(String name) {
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
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
