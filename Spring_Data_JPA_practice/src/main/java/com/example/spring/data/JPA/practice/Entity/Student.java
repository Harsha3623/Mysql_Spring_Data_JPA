package com.example.spring.data.JPA.practice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "student",
        //unique email id
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "emailId"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
           name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    //unique value
    @Column(
            name = "emailId",
            nullable = false
    )
    private String emailId;

    @Embedded

    @NotBlank
    Guardian guardian;
}
