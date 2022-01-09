package com.example.udemyjpaproject.repository;

import com.example.udemyjpaproject.UdemyJpaProjectApplication;
import com.example.udemyjpaproject.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = UdemyJpaProjectApplication.class)
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_basic() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE is_deleted=0", Course.class);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE  -> {}", resultList);
    }

    @Test
    public void native_queries_with_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?", Course.class);
        query.setParameter(1, 10001L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE  where id = ? -> {}", resultList);
    }


    @Test
    public void native_queries_with_named_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id", Course.class);
        query.setParameter("id", 10001L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE  where id = :id -> {}", resultList);
    }

    //Update

    @Test
    @Transactional
    public void native_queries_to_update() {
        Query query = em.createNativeQuery("UPDATE COURSE SET last_updated_date=sysdate()");
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("noOfRowsUpdated  -> {}", noOfRowsUpdated);
    }





}
