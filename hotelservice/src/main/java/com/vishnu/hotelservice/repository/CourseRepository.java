package com.vishnu.hotelservice.repository;

import com.vishnu.hotelservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
