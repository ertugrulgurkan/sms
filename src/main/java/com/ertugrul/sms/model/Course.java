package com.ertugrul.sms.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course extends BaseEntity{

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "number_of_classes")
    private Integer numberOfClasses;

    @Column(name = "year")
    private Integer year;

    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(name = "courses_students",joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(Integer numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
