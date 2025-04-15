package com.example.spring.data.JPA.practice.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
should be included when lazy method of fetching is included in the mapping
@ToString(
        exclude = "course"
)
 */

public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator ="course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            //fetch lazy which fetch only course material
            //fetch eager fetches course material along with the course
            fetch = FetchType.EAGER
    )
    //foreign key declaration using join
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
