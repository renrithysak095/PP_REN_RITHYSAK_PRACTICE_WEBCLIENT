package com.example.studentcourse.model.request;

import com.example.studentcourse.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime birthDate;
    private Integer courseId;
    public Student toEntity(){
        return new Student(null, this.firstName, this.lastName,this.email,this.birthDate,this.courseId);
    }

}
