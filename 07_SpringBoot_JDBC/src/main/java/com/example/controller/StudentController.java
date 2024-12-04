package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added successfully!";
    }
    @GetMapping("/getStu/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
    @GetMapping("/get")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return "Student updated successfully!";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }
}


