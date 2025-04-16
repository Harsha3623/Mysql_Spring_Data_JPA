package com.example.spring.data.JPA.practice.Controller;

import com.example.spring.data.JPA.practice.Entity.Student;
import com.example.spring.data.JPA.practice.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Save student
    @PostMapping
    public Student saveStudents(@Valid @RequestBody Student student) {
        return service.saveStudents(student);
    }

    // Get all students (non-paginated)
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable Long id) {
        return service.getStudentByID(id);
    }

    // Update student by ID
    @PutMapping("/{id}")
    public void updateStudentById(@PathVariable Long id, @RequestBody Student student) {
        service.updateStudentById(id, student);
    }

    // Delete student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id) {
        service.deleteStudentById(id);
        return ResponseEntity.ok("Student ID: " + id + " deleted successfully");
    }

    // Get all students with pagination
    @GetMapping("/page")
    public Page<Student> getAllStudentsPaginated(Pageable pageable) {
        return service.getAllStudents(pageable);
    }

    //sorting and paginating
    @GetMapping("/sorted")
    public Page<Student> getAllSorted(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return service.getAllStudents(pageable);
    }

    //searching
    @GetMapping("/search")
    public List<Student> getByFirstName(@RequestParam("firstname")String name){
        return service.getByFirstName(name);
    }

    @PutMapping("/assigncourse/{std_id}/{c_id}")
    public ResponseEntity<String> assignCourseToStudent(
            @PathVariable Long std_id,
            @PathVariable Long c_id
    ){
        service.assignCourse(std_id,c_id);
        return ResponseEntity.ok("Course id: "+c_id+" assigned to student id: "+std_id);
    }
}
