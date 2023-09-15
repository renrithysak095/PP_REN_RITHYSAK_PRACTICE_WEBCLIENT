package com.example.commonservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Integer id;
    private String courseName;
    private String courseCode;
    private String description;
    private String instructor;

}
