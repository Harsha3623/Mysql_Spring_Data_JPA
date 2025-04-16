package com.example.spring.data.JPA.practice.Service;

import com.example.spring.data.JPA.practice.Entity.Course;
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
        repository.deleteById(id);
    }
}
