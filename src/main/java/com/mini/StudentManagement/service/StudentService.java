package com.mini.StudentManagement.service;

import com.mini.StudentManagement.entity.Student;
import com.mini.StudentManagement.exception.StudentNotFoundException;
import com.mini.StudentManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> filterStudents(Integer age,String course,String department){
        if(age==null && course==null && department==null) return studentRepository.findAll();
        else if(age!=null && course==null && department==null) return studentRepository.findByAge(age);
        else if(age==null && course!=null && department==null) return studentRepository.findByCourse(course);
        else return studentRepository.findByDepartment(department);
    }

    public Student updateStudent(Long id,Student student){
        Student getStudent = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("student id "+id+" not found"));
        getStudent.setName(student.getName());
        getStudent.setEmail(student.getEmail());
        getStudent.setAge(student.getAge());
        getStudent.setCourse(student.getCourse());
        getStudent.setDepartment(student.getDepartment());
        getStudent.setPhonenumber(student.getPhonenumber());

        studentRepository.save(getStudent);
        return getStudent;
    }

    public void deleteStudent(Long id){
        studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("student id "+id+" not found"));
        studentRepository.deleteById(id);
    }
}
