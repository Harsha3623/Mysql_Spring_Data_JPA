package com.example.spring.data.JPA.practice.Controller;

import com.example.spring.data.JPA.practice.DTO.CourseDTO;
import com.example.spring.data.JPA.practice.Entity.Course;
import com.example.spring.data.JPA.practice.Service.CourseDtoService;
import com.example.spring.data.JPA.practice.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses") // plural is preferred for REST
public class CourseController {

    @Autowired
    private CourseService service;

    // Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourseDetails());
    }

    // Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCourseById(id));
    }

    // Create new course
    @PostMapping
    public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {
        Course savedCourse = service.addCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    //Update course
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        service.updateCourse(id, course);
        return ResponseEntity.ok("Course with ID " + id + " updated successfully.");
    }

    // Delete course
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Course with ID " + id + " deleted successfully.");
    }

    //native
    @GetMapping("/native")
    public List<Course> getAllCourseByNative(){
        return service.getAllCourseByNative();
    }

    //dto
    @Autowired
    private CourseDtoService courseDtoService;
    @GetMapping("/dto")
    public List<CourseDTO> getAllCourse(){
        return courseDtoService.getAllCourseDetails();
    }
}
