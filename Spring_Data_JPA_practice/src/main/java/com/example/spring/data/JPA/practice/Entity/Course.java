package com.example.spring.data.JPA.practice.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator ="course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    //bi-directional mapping
    //whenever the course list is displayed it shows course material also
    @OneToOne(
            //course is the reference which is referenced in course material
         mappedBy = "course"
    )
    private CourseMaterial material;
}
