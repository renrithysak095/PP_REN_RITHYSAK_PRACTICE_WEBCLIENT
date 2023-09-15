package com.example.courseservice.model.dto;

import com.example.courseservice.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Integer id;
    private String courseName;
    private String courseHeader;

//    public CourseDto(Integer id, String courseName, String courseHeader){
//        this.id = id;
//        this.courseName = courseName;
//        this.courseHeader = courseHeader;
//    }

}
