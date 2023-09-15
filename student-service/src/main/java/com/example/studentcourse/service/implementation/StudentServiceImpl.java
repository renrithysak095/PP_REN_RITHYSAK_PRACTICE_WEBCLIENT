package com.example.studentcourse.service.implementation;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.model.dto.StudentDto;
import com.example.studentcourse.model.request.StudentRequest;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDto> getAllCourse() {
        return studentRepository.findAll().stream().map(Student::toDto).toList();
    }

    @Override
    public StudentDto createCourse(StudentRequest studentDto) {
        return studentRepository.save(studentDto.toEntity()).toDto();
    }

    @Override
    public StudentDto getCourseById(Integer id) {
        return studentRepository.findById(id).get().toDto();
    }

    @Override
    public String removeById(Integer id) {
        studentRepository.deleteById(id);
        return "Remove successfully.";
    }

    @Override
    @Transactional
    public StudentDto updateById(Integer id, StudentRequest courseRequest) {
        Student updateObj = studentRepository.findById(id).get();

        if(updateObj != null){
            updateObj.setCourseName(courseRequest.getCourseName());
            updateObj.setCourseHeader(courseRequest.getCourseHeader());
            return studentRepository.save(updateObj).toDto();
        }
        throw new RuntimeException();
    }
}
