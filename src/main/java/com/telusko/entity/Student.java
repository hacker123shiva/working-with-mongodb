package com.telusko.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
 

@Data // Lombok generates getters, setters, toString, etc.
@Document(collection = "students") // Marks this class as a MongoDB document
public class Student {

    @Id // Indicates that this field is the primary key
    private String id;

    @NotBlank(message = "Name is mandatory") // Ensures name is not blank
    private String name;

    @NotNull(message = "Age is required") // Ensures age is not null
    private Integer age;

    @Email(message = "Email should be valid") // Validates email format
    private String email;
}
