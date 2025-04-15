package com.example.spring.data.JPA.practice.Repository;

import com.example.spring.data.JPA.practice.Entity.Course;
import com.example.spring.data.JPA.practice.Entity.CourseMaterial;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("abc")
                .credit(4)
                .build();
        CourseMaterial material = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)

                .build();
        repository.save(material);
    }
    //fetch by lazy
    @Test
    public void getCourseMaterialByLazy(){
        System.out.println(repository.findAll());
    }
}