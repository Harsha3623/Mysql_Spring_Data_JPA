package com.example.spring.data.JPA.practice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    private Long teacherId;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinColumn(
            name ="teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> course;
}
