package com.example.courseservice.model;

import com.example.courseservice.model.dto.CourseDto;
import com.example.courseservice.model.request.CourseRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "course_header")
    private String courseHeader;

    public CourseDto toDto(){
        return new CourseDto(this.id, this.courseName, this.courseHeader);
    }

    public Course toEntity(){
        return new Course(null, courseName,courseHeader);
    }


}
