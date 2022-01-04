package com.example.udemyjpaproject.repository;

import com.example.udemyjpaproject.UdemyJpaProjectApplication;
import com.example.udemyjpaproject.entity.Passport;
import com.example.udemyjpaproject.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest(classes = UdemyJpaProjectApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional //Persistence Context - Where the changes are kept track of in. And gives access to database.
    public void retrieveStudentAndPassportDetails() {
        //Eager and Lazy fetching
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);

        /*
        We said student is one to one with passport and passport. Details are stored in the passport table.
        So just by defining a simple mapping, we are able to retrieve the details of the other related entity
        just by using a simple getPassport(). Using @Transactional and LAZY fetching.
         */

        logger.info("passport -> {}", student.getPassport());

    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 30001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }






}
