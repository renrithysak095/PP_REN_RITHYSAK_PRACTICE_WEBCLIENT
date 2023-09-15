package com.example.courseservice.service.implementation;

import com.example.courseservice.model.Course;
import com.example.courseservice.model.dto.CourseDto;
import com.example.courseservice.model.request.CourseRequest;
import com.example.courseservice.repository.CourseRepository;
import com.example.courseservice.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> getAllCourse() {
        return courseRepository.findAll().stream().map(Course::toDto).toList();
    }

    @Override
    public CourseDto createCourse(CourseRequest courseRequest) {
        return courseRepository.save(courseRequest.toEntity()).toDto();
    }

    @Override
    public CourseDto getCourseById(Integer id) {
        return courseRepository.findById(id).get().toDto();
    }

    @Override
    public String removeById(Integer id) {
        courseRepository.deleteById(id);
        return "Remove successfully.";
    }

    @Override
    @Transactional
    public CourseDto updateById(Integer id, CourseRequest courseRequest) {
        Course updateObj = courseRepository.findById(id).get();

        if(updateObj != null){
            updateObj.setCourseName(courseRequest.getCourseName());
            updateObj.setCourseHeader(courseRequest.getCourseHeader());
            return courseRepository.save(updateObj).toDto();
        }
        throw new RuntimeException();
    }
}
