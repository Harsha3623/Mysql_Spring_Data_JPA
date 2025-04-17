package com.example.spring.data.JPA.practice.Controller;

import com.example.spring.data.JPA.practice.Entity.Teacher;
import com.example.spring.data.JPA.practice.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    TeacherService service;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        return ResponseEntity.ok(service.getAllTeacher());
    }

    @PutMapping()
    public ResponseEntity<String> assignCourseToTeacher(
            @RequestParam("id") Long id,
            @RequestParam("cid") Long cid
    ){
        service.assignCourseToTeacher(id,cid);
        return ResponseEntity.ok("Teacher with id:"+id+" has assigned to course with id:"+cid);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacherById(@PathVariable Long id){
        service.deleteTeacherById(id);
        return ResponseEntity.ok("Teacher with id:"+id+" deleted successfully");
    }

    //saving a teacher
    @PostMapping
    public ResponseEntity<?> saveTeacher(@Valid @RequestBody Teacher teacher){
        service.saveTeacher(teacher);
        return ResponseEntity.ok("Teacher data is saved.");
    }

    @PutMapping("/update")
    public Teacher updateTeacher(@RequestParam("id") Long id, @Valid @RequestBody Teacher teacher){
        return service.updateTeacher(id,teacher);

    }

}
