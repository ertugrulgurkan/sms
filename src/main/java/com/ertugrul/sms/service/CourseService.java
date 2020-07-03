package com.ertugrul.sms.service;

import com.ertugrul.sms.model.Course;

import java.util.List;

public interface CourseService extends CrudService<Course,Long>{
    List<Course> findByCourseNameLike(String courseName);
}

