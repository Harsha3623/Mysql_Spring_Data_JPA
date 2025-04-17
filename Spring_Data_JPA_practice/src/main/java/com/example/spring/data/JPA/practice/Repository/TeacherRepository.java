package com.example.spring.data.JPA.practice.Repository;

import com.example.spring.data.JPA.practice.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
