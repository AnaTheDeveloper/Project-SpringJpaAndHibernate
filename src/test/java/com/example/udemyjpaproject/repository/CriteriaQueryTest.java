package com.example.udemyjpaproject.repository;

import com.example.udemyjpaproject.UdemyJpaProjectApplication;
import com.example.udemyjpaproject.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest(classes = UdemyJpaProjectApplication.class)
public class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void all_courses() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);

    }

    @Test
    public void all_courses_have_10Steps(){

        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. Define Predicates etc. using Criteria Builder
        Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");

        // 4. Add Predicates etc. to the Criteria Query
        cq.where(like100Steps);

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();

        logger.info("Typed Query -> {}", resultList);

    }

    @Test
    public void all_courses_without_students() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
        cq.where(studentsIsEmpty);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);

    }

    @Test
    public void join() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Join<Object, Object> join = courseRoot.join("students");
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);

    }

    @Test
    public void left_join() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);

    }

}
