package com.vishnu.hotelservice.service.impl;

import com.vishnu.hotelservice.entity.Course;
import com.vishnu.hotelservice.repository.CourseRepository;
import com.vishnu.hotelservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Override
    public Course addCourses(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(String id) {
         courseRepository.deleteById(id);
    }

}
