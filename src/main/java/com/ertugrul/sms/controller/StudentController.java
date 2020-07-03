package com.ertugrul.sms.controller;

import com.ertugrul.sms.model.Student;
import com.ertugrul.sms.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    List<Student> all() {
        return studentService.findAll();
    }

    @PostMapping("/students")
    Student createStudent(@RequestBody Student newStudent) {
        return studentService.save(newStudent);
    }

    @GetMapping("/students/{id}")
    Student findById(@PathVariable Long id) {

        return studentService.findById(id);
    }

    @PutMapping("/students/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        newStudent.setId(id);
        Student savedStudent = studentService.save(newStudent);
        return savedStudent;
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }
    

}
