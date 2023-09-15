package com.example.courseservice.model;
import com.example.commonservice.model.CourseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_description")
    private String description;

    @Column(name = "course_instructor")
    private String instructor;


    public CourseDto toDto(){
        return new CourseDto(this.id, this.courseName, this.courseCode,this.description,this.instructor);
    }

    public Course toEntity(){
        return new Course(null, courseName, courseCode,description,instructor);
    }


}
