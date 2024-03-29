package com.vishnu.hotelservice.service;

import com.vishnu.hotelservice.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public Course addCourses(Course course);

    List<Course> getAllCourses();

     void deleteCourse(String id);

}
