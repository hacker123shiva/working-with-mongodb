package com.telusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.dao.StudentRepository;
import com.telusko.entity.Student;
import com.telusko.exception.StudentNotFoundException;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create Student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student by ID
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    // Update Student
    public Student updateStudent(String id, Student student) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        student.setId(id); // Ensure the ID remains unchanged
        return studentRepository.save(student);
    }

    // Delete Student
    public void deleteStudent(String id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    // Custom query methods
    public List<Student> findByName(String name) {
        List<Student> students = studentRepository.findByName(name);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students found with name: " + name);
        }
        return students;
    }

    public List<Student> findByAgeGreaterThan(int age) {
        List<Student> students = studentRepository.findByAgeGreaterThan(age);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students found older than age: " + age);
        }
        return students;
    }
}
