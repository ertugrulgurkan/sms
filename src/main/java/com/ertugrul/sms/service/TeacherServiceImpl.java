package com.ertugrul.sms.service;

import com.ertugrul.sms.model.Teacher;
import com.ertugrul.sms.repository.CourseRepository;
import com.ertugrul.sms.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);
        return teachers;
    }

    @Override
    public Teacher findById(Long aLong) {
        return teacherRepository.findById(aLong).orElse(null);
    }

    @Override
    public Teacher save(Teacher object) {
        object.getCourses().stream().forEach((item) -> {
                item.setTeacher(object);
                courseRepository.save(item);
        });
        return teacherRepository.save(object);
    }

    @Override
    public void delete(Teacher object) {
        teacherRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teacherRepository.deleteById(aLong);
    }

    @Override
    public List<Teacher> findByFirstNameLike(String firstName) {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findByFirstNameLike(firstName).forEach(teachers::add);
        return teachers;
    }
}
