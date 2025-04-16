package com.example.spring.data.JPA.practice.Repository;

import com.example.spring.data.JPA.practice.Entity.Student;
import org.springframework.data.domain.Page; // Correct import for Page
import org.springframework.data.domain.Pageable; // Correct import for Pageable
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query to find students by first name
    public List<Student> findByFirstName(String name);

    // Pagination support for finding all students
    public Page<Student> findAll(Pageable pageable);

    //sorting
    public List<Student> findAll(Sort sort);

    // Native query example (you can uncomment and use if needed)
    // @Query(
    //         value = "SELECT * FROM students WHERE ...",
    //         nativeQuery = true
    // )
    // public List<Student> findNativeQuery();

}
