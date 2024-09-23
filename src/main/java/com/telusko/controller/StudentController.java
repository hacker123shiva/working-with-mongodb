package com.telusko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.telusko.entity.Student;
import com.telusko.service.StudentService;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create Student
    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // Get all Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    // Update Student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @Valid @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

    // Custom query: Find by name
    @GetMapping("/search/byName")
    public List<Student> findByName(@RequestParam String name) {
        return studentService.findByName(name);
    }

    // Custom query: Find by age greater than
    @GetMapping("/search/byAgeGreaterThan")
    public List<Student> findByAgeGreaterThan(@RequestParam int age) {
        return studentService.findByAgeGreaterThan(age);
    }
}
