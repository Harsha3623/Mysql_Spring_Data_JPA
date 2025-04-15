package com.example.spring.data.JPA.practice.Repository;

import com.example.spring.data.JPA.practice.Entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

}
