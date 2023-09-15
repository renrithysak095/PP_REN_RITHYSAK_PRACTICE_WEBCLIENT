package com.example.studentcourse.service.implementation;
import com.example.commonservice.model.CourseDto;
import com.example.commonservice.response.ApiResponse;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.model.dto.StudentDto;
import com.example.studentcourse.model.request.StudentRequest;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final WebClient courseInstance;

    public StudentServiceImpl(StudentRepository studentRepository, WebClient.Builder courseInstance) {
        this.studentRepository = studentRepository;
        this.courseInstance = courseInstance.baseUrl("http://localhost:2002/api/v1").build();
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> responses = new ArrayList<>();
        for (Student st: students) {
            ApiResponse courseDto = courseInstance
                    .get()
                    .uri("/courses/{id}", st.getCourseId())
                    .retrieve()
                    .bodyToMono(ApiResponse.class)
                    .block();
            ObjectMapper objectMapper = new ObjectMapper();
            CourseDto courseDtoObject = objectMapper.convertValue(courseDto.getPayload(), CourseDto.class);
            responses.add(new StudentDto(st.getId(),st.getFirstname(),st.getLastname(),st.getEmail(),st.getBirthDate(),courseDtoObject));
        }
        return responses;
    }

    @Override
    public StudentDto createStudent(StudentRequest studentRequest) {

        Integer courseId = studentRequest.getCourseId();
        ApiResponse courseDto = courseInstance
                .get()
                .uri("/courses/{id}", courseId)
                .retrieve()
                .bodyToMono(ApiResponse.class)
                .block();
        ObjectMapper objectMapper = new ObjectMapper();
        CourseDto courseDtoObject = objectMapper.convertValue(courseDto.getPayload(), CourseDto.class);

         return studentRepository.save(new Student(null,studentRequest.getFirstName(),studentRequest.getLastName(),studentRequest.getEmail(),studentRequest.getBirthDate(),studentRequest.getCourseId())).toDto(courseDtoObject);

    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Student student = studentRepository.findById(id).get();
        ApiResponse courseDto = courseInstance
                .get()
                .uri("/courses/{id}", student.getCourseId())
                .retrieve()
                .bodyToMono(ApiResponse.class)
                .block();
        ObjectMapper objectMapper = new ObjectMapper();
        CourseDto courseDtoObject = objectMapper.convertValue(courseDto.getPayload(), CourseDto.class);
        return new StudentDto(student.getId(),student.getFirstname(),student.getLastname(),student.getEmail(),student.getBirthDate(),courseDtoObject);
    }

    @Override
    public String removeStudentById(Integer id) {
        studentRepository.deleteById(id);
        return "Deleted Student Entity by Id:"+id+" Successfully";
    }

    @Override
    public StudentDto updateStudentById(Integer id, StudentRequest studentRequest) {
        Student updateObj = studentRepository.findById(id).get();
        if(updateObj != null){
            updateObj.setFirstname(studentRequest.getFirstName());
            updateObj.setLastname(studentRequest.getLastName());
            updateObj.setEmail(studentRequest.getEmail());
            updateObj.setBirthDate(studentRequest.getBirthDate());
            updateObj.setCourseId(studentRequest.getCourseId());
            ApiResponse courseDto = courseInstance
                    .get()
                    .uri("/courses/{id}", studentRequest.getCourseId())
                    .retrieve()
                    .bodyToMono(ApiResponse.class)
                    .block();
            ObjectMapper objectMapper = new ObjectMapper();
            CourseDto courseDtoObject = objectMapper.convertValue(courseDto.getPayload(), CourseDto.class);
            return studentRepository.save(updateObj).toDto(courseDtoObject);
        }
        throw new RuntimeException();
    }
}
