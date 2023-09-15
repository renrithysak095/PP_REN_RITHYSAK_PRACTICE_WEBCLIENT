package com.example.courseservice.controller;

import com.example.courseservice.model.dto.CourseDto;
import com.example.courseservice.model.request.CourseRequest;
import com.example.courseservice.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourse(){
        return ResponseEntity.ok().body(courseService.getAllCourse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok().body(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseRequest courseRequest){
        return ResponseEntity.ok().body(courseService.createCourse(courseRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok().body(courseService.removeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateById(@PathVariable Integer id,
                                             @RequestBody CourseRequest courseRequest){
        return ResponseEntity.ok().body(courseService.updateById(id,courseRequest));
    }


}
