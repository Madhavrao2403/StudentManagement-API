package com.mini.StudentManagement.controller;


import com.mini.StudentManagement.entity.Student;
import com.mini.StudentManagement.repository.StudentRepository;
import com.mini.StudentManagement.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
            Student added = studentService.addStudent(student);
            URI location = URI.create("/students?id="+added.getId());
           return ResponseEntity.created(location).body(added);
    }

    @GetMapping
    public ResponseEntity<List<Student>> filterStudents(@RequestParam(value="age",required = false) Integer age,
                                                        @RequestParam(value="course",required = false) String course,
                                                        @RequestParam(value="department",required = false) String department){
           return ResponseEntity.ok(studentService.filterStudents(age,course,department));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestParam(value = "id",required = true) Long id,@RequestBody Student student){
          return ResponseEntity.ok(studentService.updateStudent(id,student));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestParam(value = "id",required = true) Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
