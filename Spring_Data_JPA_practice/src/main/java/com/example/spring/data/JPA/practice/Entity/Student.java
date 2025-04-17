package com.example.spring.data.JPA.practice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
@Table(
        name = "student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "emailId"
        )
)
@ToString(exclude = "courses")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator ="student_sequence"
    )
        private Long studentId;

    @NotBlank(message = "firstname is required")
    private String firstName;

    @NotBlank(message = "last name is required")
    private String lastName;

    @Column(name = "emailId", nullable = false)
    @NotBlank(message = "email is required")
    private String emailId;

    @Embedded
    //without guardian the student object cannot be created
    @NotNull(message = "Guardian is required.")
    private Guardian guardian;



    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnoreProperties("students") // Ignore course -> students to break loop
    private Set<Course> courses;
//        @ManyToMany(mappedBy = "students") // No cascade delete here
//        private Set<Course> courses;
}