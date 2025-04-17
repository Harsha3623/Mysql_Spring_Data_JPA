package com.example.spring.data.JPA.practice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


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



    //relational mapping of material
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    // Avoiding back ref issue
    @NotNull(message = "Course material is required")
    @JsonIgnoreProperties("course")
    private CourseMaterial material;



    @ManyToMany(mappedBy = "courses")
    // Ignore back ref to avoid infinite loop
    @JsonIgnoreProperties("courses")
    private Set<Student> students;
//@ManyToMany(cascade = CascadeType.PERSIST) // Persist new students, but do not delete them
//@JoinTable(
//        name = "student_course",
//        joinColumns = @JoinColumn(name = "course_id"),
//        inverseJoinColumns = @JoinColumn(name = "student_id")
//)
//private Set<Student> students;



    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

}