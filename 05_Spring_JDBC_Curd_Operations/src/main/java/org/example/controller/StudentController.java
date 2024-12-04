package org.example.controller;


import org.example.Entity.Student;
import org.example.service.StudentService;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    public String saveStudent(Student stu){
        return  studentService.saveStudent(stu);
    }


    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentService.getStudentById(id);
    }


    public String updateStudentById(int id, Student updatedStudent) {
        return studentService.updateStudentById(id, updatedStudent);
    }


    public void deleteStudent(int id) {
        studentService.deleteStudent(id);
    }

    public String deleteAllStudents() {
        return studentService.deleteAllStudents();
    }
}
