package com.example.studentcourse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student Service", version = "1.0", description = "Student Service"))
public class StudentCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentCourseApplication.class, args);
    }

}
