package com.ertugrul.sms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student extends Person{

    @Column(name = "student_number")
    private Integer studentNumber;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }
}
