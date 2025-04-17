package com.example.spring.data.JPA.practice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue
    private Long teacherId;

    @NotBlank(message = "first name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;



    @OneToMany
    @JoinColumn(
            name ="teacher_id",
            referencedColumnName = "teacherId"
    )
    @JsonIgnoreProperties({"students", "teacher"})
    private List<Course> course;
}
