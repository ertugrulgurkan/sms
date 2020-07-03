package com.ertugrul.sms.repository;

import com.ertugrul.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameLike(String firstName);
}
