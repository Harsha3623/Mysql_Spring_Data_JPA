package com.example.spring.data.JPA.practice.Repository;

import com.example.spring.data.JPA.practice.Entity.Guardian;
import com.example.spring.data.JPA.practice.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

    @Test
    public void saveStudent() {
        Student s = Student.builder().
                emailId("abc@123.com")
                .firstName("abc")
                .lastName("xyz")
//                .guardianName("guardian")
//                .guardianEmail("abc@123.com")
//                .guardianMobile("1234567890")
                .build();
        repository.save(s);
    }

    @Test
    public void saveStudentswithguardian(){
        Guardian guardian = Guardian.builder().
                name("")
                .mobile("123823932").
                email("nikhil@123.com").
                build();
        Student student = Student.builder()
                .firstName("harsha")
                .lastName("K R")
                .emailId("harsha@234.com")
                .guardian(guardian)
                .build();

        repository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> students = repository.findAll();
        System.out.println(students);
    }
    @Test
    public void findByName(){
        List<Student> res =  repository.findByFirstName("harsha");
        System.out.println(res);
    }

}