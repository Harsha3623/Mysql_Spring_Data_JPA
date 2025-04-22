package com.example.spring.data.JPA.practice.Service;

import com.example.spring.data.JPA.practice.DTO.CourseDTO;
import com.example.spring.data.JPA.practice.Entity.Course;
import com.example.spring.data.JPA.practice.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseDtoService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> getAllCourseDetails(){
        return courseRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    public CourseDTO convertEntityToDto(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setCredit(course.getCredit());
        return courseDTO;
    }
}
