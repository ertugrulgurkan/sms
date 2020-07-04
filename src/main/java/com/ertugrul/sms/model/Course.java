package com.ertugrul.sms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COURSE")
public class Course extends BaseEntity{

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "number_of_classes")
    private Integer numberOfClasses;

    @Column(name = "year")
    private Integer year;

    @JsonBackReference
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY , cascade = CascadeType.DETACH)
    private Set<Student> students = new HashSet<>();


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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
