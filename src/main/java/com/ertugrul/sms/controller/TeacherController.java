package com.ertugrul.sms.controller;

import com.ertugrul.sms.model.Teacher;
import com.ertugrul.sms.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    List<Teacher> all() {
        return teacherService.findAll();
    }

    @PostMapping("/teachers")
    Teacher createTeacher(@RequestBody Teacher newTeacher) {
        return teacherService.save(newTeacher);
    }

    @GetMapping("/teachers/{id}")
    Teacher findById(@PathVariable Long id) {

        return teacherService.findById(id);
    }

    @PutMapping("/teachers/{id}")
    Teacher updateTeacher(@RequestBody Teacher newTeacher, @PathVariable Long id) {
        newTeacher.setId(id);
        Teacher savedTeacher = teacherService.save(newTeacher);
        return savedTeacher;
    }

    @DeleteMapping("/teachers/{id}")
    void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteById(id);
    }

    @GetMapping(value = "/teachers/search")
    public List<Teacher> searchTeachersByLastName(@RequestParam("name") String firstName){
        List<Teacher> teacherSearchList = teacherService.findByFirstNameLike("%"+ firstName + "%");
        return teacherSearchList;
    }

}
