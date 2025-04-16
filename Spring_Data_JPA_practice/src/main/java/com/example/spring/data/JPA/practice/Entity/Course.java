package com.example.spring.data.JPA.practice.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "students")
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

    @NotBlank(message = "title is required")
    private String title;

    @NotNull(message = "credit is required")
    private Integer credit;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    // Avoiding back ref issue
    @JsonIgnoreProperties("course")
    private CourseMaterial material;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    // Ignore back ref to avoid infinite loop
    @JsonIgnoreProperties("courses")
    private Set<Student> students;
}
