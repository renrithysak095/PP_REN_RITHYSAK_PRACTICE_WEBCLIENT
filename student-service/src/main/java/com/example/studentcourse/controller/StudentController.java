package com.example.studentcourse.controller;
import com.example.commonservice.response.ApiResponse;
import com.example.studentcourse.model.dto.StudentDto;
import com.example.studentcourse.model.request.StudentRequest;
import com.example.studentcourse.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ApiResponse<List<StudentDto>> getAllStudent(){
        ApiResponse<List<StudentDto>> response = new ApiResponse<>();
        response.setPayload(studentService.getAllStudent());
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Fetched Successfully");
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDto>> getStudentById(@PathVariable Integer id){
        ApiResponse<StudentDto> response = new ApiResponse<>();
        response.setPayload(studentService.getStudentById(id));
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.OK);
        response.setMessage("Fetched Student By Id Successfully");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentDto>> createStudent(@RequestBody StudentRequest studentRequest){
        ApiResponse<StudentDto> response = new ApiResponse<>();
        response.setPayload(studentService.createStudent(studentRequest));
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.CREATED);
        response.setMessage("Created Successfully");
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Integer id){
        ApiResponse<String> response = new ApiResponse<>();
        response.setPayload(studentService.removeStudentById(id));
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.ACCEPTED);
        response.setMessage("Deleted Successfully");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDto>> updateById(@PathVariable Integer id,
                                             @RequestBody StudentRequest studentRequest){
        ApiResponse<StudentDto> response = new ApiResponse<>();
        response.setPayload(studentService.updateStudentById(id,studentRequest));
        response.setTime(LocalDateTime.now());
        response.setStatus(HttpStatus.ACCEPTED);
        response.setMessage("Updated Successfully");
        return ResponseEntity.ok().body(response);
    }


}
