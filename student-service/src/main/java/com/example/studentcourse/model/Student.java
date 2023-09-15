package com.example.studentcourse.model;

import com.example.studentcourse.model.dto.StudentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_header")
    private String courseHeader;

    public StudentDto toDto(){
        return new StudentDto(this.id, this.courseName, this.courseHeader);
    }

    public Student toEntity(){
        return new Student(null, courseName,courseHeader);
    }


}
