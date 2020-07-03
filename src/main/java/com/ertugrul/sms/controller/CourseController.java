package com.ertugrul.sms.controller;

import com.ertugrul.sms.model.Course;
import com.ertugrul.sms.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    List<Course> all() {
        return courseService.findAll();
    }

    @PostMapping("/courses")
    Course createCourse(@RequestBody Course newCourse) {
        return courseService.save(newCourse);
    }

    @GetMapping("/courses/{id}")
    Course findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PutMapping("/courses/{id}")
    Course updateCourse(@RequestBody Course newCourse, @PathVariable Long id) {
        newCourse.setId(id);
        Course savedCourse = courseService.save(newCourse);
        return savedCourse;
    }

    @DeleteMapping("/courses/{id}")
    void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @GetMapping(value = "/courses/search")
    public List<Course> searchCoursesByCourseName(@RequestParam("name") String courseName){
        List<Course> courseSearchList = courseService.findByCourseNameLike("%"+ courseName + "%");
        return courseSearchList;
    }

}
