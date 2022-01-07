package com.example.udemyjpaproject.repository;

import com.example.udemyjpaproject.entity.Employee;
import com.example.udemyjpaproject.entity.FullTimeEmployee;
import com.example.udemyjpaproject.entity.PartTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public void insertEmployee(Employee employee) {
        em.persist(employee);
    }

    //Works with SINGLE_TABLE, JOINED and TABLE_PER_CLASS
    public List<Employee> retrieveAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    //Works with @MappedSuperclass
    public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
        return em.createQuery("SELECT e FROM PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
        return em.createQuery("SELECT e FROM FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }





}
