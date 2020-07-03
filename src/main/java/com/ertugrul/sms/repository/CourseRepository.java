package com.ertugrul.sms.repository;

import com.ertugrul.sms.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByCourseNameLike(String courseName);
}
