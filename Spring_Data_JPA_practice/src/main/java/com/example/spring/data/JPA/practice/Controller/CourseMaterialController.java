package com.example.spring.data.JPA.practice.Controller;

import com.example.spring.data.JPA.practice.Entity.CourseMaterial;
import com.example.spring.data.JPA.practice.Service.CourseMaterialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coursematerial")
public class CourseMaterialController {

    @Autowired
    CourseMaterialService service;

    @PutMapping()
    public CourseMaterial updateCourseMaterial(@Valid @RequestBody CourseMaterial courseMaterial){
        return service.updateCourseMaterial(courseMaterial);
    }

}
