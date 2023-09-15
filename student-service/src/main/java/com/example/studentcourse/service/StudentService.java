package com.example.studentcourse.service;

import com.example.studentcourse.model.dto.StudentDto;
import com.example.studentcourse.model.request.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<StudentDto> getAllCourse();
    StudentDto createCourse(StudentRequest courseRequest);
    StudentDto getCourseById(Integer id);
    String removeById(Integer id);
    StudentDto updateById(Integer id, StudentRequest courseRequest);
}
