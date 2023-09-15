package com.example.courseservice.controller;

import com.example.commonservice.model.CourseDto;
import com.example.commonservice.response.ApiResponse;
import com.example.courseservice.model.request.CourseRequest;
import com.example.courseservice.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseDto>>> getAllCourse(){
        ApiResponse<List<CourseDto>> response = new ApiResponse<>();
        response.setPayload(courseService.getAllCourse());
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Fetched Successfully");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseDto>> getById(@PathVariable Integer id){
        ApiResponse<CourseDto> response = new ApiResponse<>();
        response.setPayload(courseService.getCourseById(id));
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Fetched by Id Successfully");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseDto>> createCourse(@RequestBody CourseRequest courseRequest){
        ApiResponse<CourseDto> response = new ApiResponse<>();
        response.setPayload(courseService.createCourse(courseRequest));
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.CREATED);
        response.setMessage("Created Successfully");
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Integer id){
        ApiResponse<String> response = new ApiResponse<>();
        response.setPayload(courseService.removeById(id));
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.ACCEPTED);
        response.setMessage("Deleted Successfully");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseDto>> updateById(@PathVariable Integer id,
                                                @RequestBody CourseRequest courseRequest){
        ApiResponse<CourseDto> response = new ApiResponse<>();
        response.setPayload(courseService.updateById(id,courseRequest));
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.ACCEPTED);
        response.setMessage("Updated Successfully");
        return ResponseEntity.ok().body(response);
    }


}
