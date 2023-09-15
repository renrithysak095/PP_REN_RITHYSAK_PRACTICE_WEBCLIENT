package com.example.courseservice.model.request;

import com.example.courseservice.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private String courseName;
    private String courseHeader;

    public Course toEntity(){
        return new Course(null, this.courseName, this.courseHeader);
    }

}
