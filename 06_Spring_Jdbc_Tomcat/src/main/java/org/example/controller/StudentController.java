package org.example.controller;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepo;

    public StudentController(StudentRepository student) {
        this.studentRepo = student;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentRepo.save(student);
        return new ResponseEntity<>("Student added successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Student> getStudents() {
        return studentRepo.getAll();
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        studentRepo.update(student);
        return "Student updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentRepo.delete(id);
        return "Student deleted successfully!";
    }
}

