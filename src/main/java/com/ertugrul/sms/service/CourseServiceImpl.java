package com.ertugrul.sms.service;

import com.ertugrul.sms.model.Course;
import com.ertugrul.sms.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    @Override
    public Course findById(Long aLong) {
        return courseRepository.findById(aLong).orElse(null);
    }

    @Override
    public Course save(Course object) {
        return courseRepository.save(object);
    }

    @Override
    public void delete(Course object) {
        courseRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        courseRepository.deleteById(aLong);
    }

    @Override
    public List<Course> findByCourseNameLike(String courseName) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByCourseNameLike(courseName).forEach(courses::add);
        return courses;
    }
}
