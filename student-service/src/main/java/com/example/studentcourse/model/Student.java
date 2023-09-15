package com.example.studentcourse.model;

import com.example.commonservice.model.CourseDto;
import com.example.studentcourse.model.dto.StudentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @Column(name = "student_firstname")
    private String firstname;

    @Column(name = "student_lastname")
    private String lastname;

    @Column(name = "student_email")
    private String email;

    @Column(name = "student_birthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime birthDate;

    private Integer courseId;


    public StudentDto toDto(CourseDto courseDto){
        return new StudentDto(this.id,this.firstname,this.lastname,this.email,this.birthDate, courseDto);
    }


}
