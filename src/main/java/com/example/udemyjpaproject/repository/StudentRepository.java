package com.example.udemyjpaproject.repository;

import com.example.udemyjpaproject.entity.Course;
import com.example.udemyjpaproject.entity.Passport;
import com.example.udemyjpaproject.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {

        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Mike");
        //The student is the owning side because it contains the passport.

        student.setPassport(passport);
        em.persist(student);
    }

    public void insertHardcodedStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        em.persist(student);
        em.persist(course);

        student.addCourses(course);
        course.addStudents(student);
        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course){
        student.addCourses(course);
        course.addStudents(student);

        em.persist(student);
        em.persist(course);
    }





}
