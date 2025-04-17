package com.example.spring.data.JPA.practice.Service;

import com.example.spring.data.JPA.practice.Entity.CourseMaterial;
import com.example.spring.data.JPA.practice.Repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseMaterialService {

    @Autowired
    CourseMaterialRepository repository;

    public CourseMaterial updateCourseMaterial(CourseMaterial courseMaterial) {
        return repository.save(courseMaterial);
    }
}
