package com.example.courseservice.service;
import com.example.commonservice.model.CourseDto;
import com.example.courseservice.model.request.CourseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<CourseDto> getAllCourse();
    CourseDto createCourse(CourseRequest courseRequest);
    CourseDto getCourseById(Integer id);
    String removeById(Integer id);
    CourseDto updateById(Integer id, CourseRequest courseRequest);
}
