package com.mini.StudentManagement.repository;

import com.mini.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByAge(Integer age);
     List<Student> findByCourse(String course);
     List<Student> findByDepartment(String department);
}
