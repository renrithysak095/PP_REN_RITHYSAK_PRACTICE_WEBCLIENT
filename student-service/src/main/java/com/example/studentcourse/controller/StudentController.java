package com.example.studentcourse.controller;
import com.example.studentcourse.model.dto.StudentDto;
import com.example.studentcourse.model.request.StudentRequest;
import com.example.studentcourse.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllCourse(){
        return ResponseEntity.ok().body(studentService.getAllCourse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok().body(studentService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto> createCourse(@RequestBody StudentRequest studentRequest){
        return ResponseEntity.ok().body(studentService.createCourse(studentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok().body(studentService.removeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateById(@PathVariable Integer id,
                                             @RequestBody StudentRequest studentRequest){
        return ResponseEntity.ok().body(studentService.updateById(id,studentRequest));
    }


}
