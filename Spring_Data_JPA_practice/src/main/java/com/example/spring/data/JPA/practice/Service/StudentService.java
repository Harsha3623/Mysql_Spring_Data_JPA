package com.example.spring.data.JPA.practice.Service;

import com.example.spring.data.JPA.practice.Entity.Course;
import com.example.spring.data.JPA.practice.Entity.Student;
import com.example.spring.data.JPA.practice.Repository.CourseRepository;
import com.example.spring.data.JPA.practice.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    // Save student
    @Transactional
    public Student saveStudents(Student student) {
        return repository.save(student);
    }

    // Delete student by ID
    @Transactional
    public void deleteStudentById(Long id) {
        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found!"));
        repository.delete(student);
    }

    // Update student by ID
    @Transactional
    public void updateStudentById(Long id, Student student) {
        Student existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found!"));

        // Update the existing student with the new data
        existing.setCourses(student.getCourses());
        existing.setGuardian(student.getGuardian());
        existing.setEmailId(student.getEmailId());
        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());

        repository.save(existing);
    }

    // Get student by ID
    public Student getStudentByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student with id: " + id + " not found!"));
    }

    // Get all students (non-paginated)
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Get all students with pagination
    public Page<Student> getAllStudents(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Student> getByFirstName(String name) {
        return repository.findByFirstName(name);
    }

    @Autowired
    CourseRepository courseRepository;

    public void assignCourse(Long stdId, Long cId) {

        //native query
        Student student = repository.findById(stdId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(cId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        student.getCourses().add(course);
        repository.save(student);
    }
}
