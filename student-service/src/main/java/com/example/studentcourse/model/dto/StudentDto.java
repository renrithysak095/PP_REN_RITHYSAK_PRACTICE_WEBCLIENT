package com.example.studentcourse.model.dto;

import com.example.commonservice.model.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDateTime birthDate;
    private CourseDto courseDto;

}
