package com.ertugrul.sms.repository;

import com.ertugrul.sms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
