package com.example.spring.data.JPA.practice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private Guardian guardian;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnoreProperties("students") // Ignore course -> students to break loop
    private Set<Course> courses;
}
