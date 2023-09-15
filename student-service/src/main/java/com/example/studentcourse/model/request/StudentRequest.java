package com.example.studentcourse.model.request;

import com.example.studentcourse.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String courseName;
    private String courseHeader;
    public Student toEntity(){
        return new Student(null, this.courseName, this.courseHeader);
    }

}
