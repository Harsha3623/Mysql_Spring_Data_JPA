package com.example.spring.data.JPA.practice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long courseId;

    private String title;

    private Integer credit;

}
