package com.example.spring.data.JPA.practice.Service;

import com.example.spring.data.JPA.practice.Entity.Course;
import com.example.spring.data.JPA.practice.Entity.CourseMaterial;
import com.example.spring.data.JPA.practice.Entity.Student;
import com.example.spring.data.JPA.practice.Repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    // Get all courses
    public List<Course> getAllCourseDetails() {
        return repository.findAll();
    }

    // Get course by ID
    public Course getCourseById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Course with ID " + id + " not found."));
    }

    //Add a new course
    public Course addCourse(Course course) {
        CourseMaterial material = course.getMaterial();
        //when we pass both course and course material at a time
        if(material!=null){
            material.setCourse(course);
        }
        return repository.save(course); // return saved entity directly
    }

    // Update course details
    @Transactional
    public void updateCourse(Long id, Course course) {
        Course existing = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Course with ID " + id + " not found.")
        );

        existing.setTitle(course.getTitle());
        existing.setCredit(course.getCredit());
        // if you plan to update relationships, do it here

        // save not needed due to transactional context with managed entity
    }

    //Delete course
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Course with ID " + id + " does not exist.");
        }
        Course course = repository.findById(id).orElseThrow(()-> new RuntimeException("Course is not present"));
        for(Student student:course.getStudents()){
            student.getCourses().remove(course);
        }
        course.getStudents().clear();

        repository.delete(course);
    }

    public List<Course> getAllCourseByNative() {
        return repository.gtAllCourseDetails();
    }
}
