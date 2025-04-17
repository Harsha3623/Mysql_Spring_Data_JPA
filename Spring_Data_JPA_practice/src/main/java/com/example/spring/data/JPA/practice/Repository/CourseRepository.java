package com.example.spring.data.JPA.practice.Repository;

import com.example.spring.data.JPA.practice.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query(
            value = "Select * from course",
            nativeQuery = true
    )
    public List<Course> gtAllCourseDetails();

}
