package com.example.udemyjpaproject;

import com.example.udemyjpaproject.entity.*;
import com.example.udemyjpaproject.repository.CourseRepository;
import com.example.udemyjpaproject.repository.EmployeeRepository;
import com.example.udemyjpaproject.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UdemyJpaProjectApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(UdemyJpaProjectApplication.class, args);
    }

    /*
    The L appears at the end of the numbers because the datatype is Long not long.
    Long is an object, long is a primitive type.
     */

    @Override
    public void run(String... args) throws Exception {

//        Course course = repository.findById(10001L);
//
//        logger.info("Course 10001 -> {}", course);
//
//        repository.save(new Course("Microservices Introduction"));

        //Entity Manager
//        repository.playWithEntityManager();

        //Hibernate Annotations
//        repository.playWithHibernateAnnotations();

        //Student Repository Call
//        studentRepository.saveStudentWithPassport();

        //Course Repository Call
//        courseRepository.addHardcodedReviewsForCourse();

//        List<Review> newReviews = new ArrayList<>();
//        newReviews.add(new Review("4", "Poor management"));
//        newReviews.add(new Review("10", "Fantastic Course!"));
//
//        courseRepository.addReviewsForCourse(10003L, newReviews);

        //Student Repository method call
//        studentRepository.insertHardcodedStudentAndCourse();
//        studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));

        //Insert Employees
//        employeeRepository.insertEmployee(new PartTimeEmployee("Mandy", new BigDecimal("50")));
//        employeeRepository.insertEmployee(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//        logger.info("All employees -> {}", employeeRepository.retrieveAllEmployees());

        //SuperMappedclass employee call
//        employeeRepository.insertEmployee(new PartTimeEmployee("Mandy", new BigDecimal("50")));
//        employeeRepository.insertEmployee(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//        logger.info("All full time employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
//        logger.info("All part time employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());


        /*
        Notes on Entity Manager Life Cycle and Annotations

        The first one is post load. If you mark a method in an entity with the notation at Postlude, it would be called
        as soon as the entity is retrieved and loaded. If there is a select query fired and that specific entity is being
        loaded, this specific method on the entity would be called the Post.

        Post Persist is when you call the post method. So when you say entity manager, what persist? This specific entity,
        the post possessed method would be called, it would be called after the entity is persisted to the database, the
        post removed would be called when you would delete and when we would remove an entity so you would immediately
        remove a specific entity. The post remove would be called after the entity removed from the database after to delete query is fired.

        The post update is after an update to an entity is filed with the database. The other attributes which are present
        in here at pre-persist, pre remove and pre update. These are all called before persisting. So before you possess
        the data you would call pre-persist, just before you remove an entity you would call pre remove, and just before
        you would update an entity, you would have pre update method called.
         */
    }
}
