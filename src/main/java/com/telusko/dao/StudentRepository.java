package com.telusko.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.telusko.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    // Custom query methods
    List<Student> findByName(String name);
    List<Student> findByAgeGreaterThan(int age);
}
