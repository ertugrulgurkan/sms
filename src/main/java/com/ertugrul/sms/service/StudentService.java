package com.ertugrul.sms.service;

import com.ertugrul.sms.model.Student;

import java.util.List;

public interface StudentService extends CrudService<Student,Long> {

    List<Student> findByFirstNameLike(String firstName);
}
