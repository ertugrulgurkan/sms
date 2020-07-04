package com.ertugrul.sms.service;

import com.ertugrul.sms.model.Teacher;

import java.util.List;

public interface TeacherService extends CrudService<Teacher,Long> {

    List<Teacher> findByFirstNameLike(String firstName);
}
