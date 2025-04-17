package com.example.spring.data.JPA.practice.Service;

import com.example.spring.data.JPA.practice.Entity.Course;
import com.example.spring.data.JPA.practice.Entity.Teacher;
import com.example.spring.data.JPA.practice.Repository.CourseRepository;
import com.example.spring.data.JPA.practice.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository repository;

    //course repository reference
    @Autowired
    CourseRepository courseRepository;

    public List<Teacher> getAllTeacher() {
        return repository.findAll();
    }

    @Transactional
    public void assignCourseToTeacher(Long id, Long cid) {
        Teacher existing = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Teacher not found!")
        );
        Course course = courseRepository.findById(cid).orElseThrow(
                ()-> new RuntimeException("Course not found!")
        );

        //existing.getCourse().add(course);
//        existing.getCourse().add(course);
//        repository.save(existing);
        existing.getCourse().add(course);
        //course.setTeacher(existing);
        //courseRepository.save(course);
        repository.save(existing);
    }

    public void deleteTeacherById(Long id) {
        repository.deleteById(id);
    }

    public void saveTeacher(Teacher teacher) {
        repository.save(teacher);
    }

    public Teacher updateTeacher(Long id, @Valid Teacher teacher) {
        Teacher existing  = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Teacher not found!")
        );
        existing.setFirstName(teacher.getFirstName());
        existing.setLastName(teacher.getLastName());


        return repository.save(existing);
    }
}
