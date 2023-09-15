package com.example.studentcourse.service;
import com.example.studentcourse.model.dto.StudentDto;
import com.example.studentcourse.model.request.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDto> getAllStudent();
    StudentDto createStudent(StudentRequest studentRequest);
    StudentDto getStudentById(Integer id);
    String removeStudentById(Integer id);
    StudentDto updateStudentById(Integer id, StudentRequest studentRequest);
}
