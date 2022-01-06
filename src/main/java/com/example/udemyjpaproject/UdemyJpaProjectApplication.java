package com.example.udemyjpaproject;

import com.example.udemyjpaproject.entity.Course;
import com.example.udemyjpaproject.entity.Review;
import com.example.udemyjpaproject.entity.Student;
import com.example.udemyjpaproject.repository.CourseRepository;
import com.example.udemyjpaproject.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UdemyJpaProjectApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

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

    }
}
