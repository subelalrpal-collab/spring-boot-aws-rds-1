package com.example.spring_boot_aws_rds.controller;

import com.example.spring_boot_aws_rds.dtos.Student;
import com.example.spring_boot_aws_rds.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/students")
public class StudentController {
   private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentRepository.getAllStudents();
    }

    @PostMapping("/students")
    public String saveStudent(@RequestBody Student student) {
        int id = studentRepository.saveStudent(student.id(), student.name());
        return id==1?"Student saved ":"Student not saved";
    }
}
