package com.example.udemyjpaproject.repository;

import com.example.udemyjpaproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@RepositoryRestResource(path="courses") //Used with spring-boot-starter-rest in pom //localhost:8080/courses
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

    //Custom Queries

    List<Course> findByName(String name);

    //More examples of custom queries you might want

    List<Course> findByNameAndId(String name, Long id);

    List<Course> countByName(String name);

    List<Course> findByNameOrderByIdDesc(String name);

    List<Course> deleteByName(String name);


    //Can also define queries

    //JPQL query
    @Query("SELECT c FROM Course c WHERE name LIKE '%10 Steps'")
    List<Course> courseWith10StepsInName();

    //Native query
    @Query(value="SELECT * FROM Course WHERE name LIKE '%10 Steps%'", nativeQuery = true)
    List<Course> courseWith10StepsInName2();

    //Named query
    @Query(name = "query_get_100_Step_courses")
    List<Course> courseWith100StepsInNameUsingNamedQuery();

}
