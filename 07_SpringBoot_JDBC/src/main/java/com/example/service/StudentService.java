package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public int addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public int updateStudent(Student student) {
        return studentRepository.update(student);
    }

    public int deleteStudent(int id) {
        return studentRepository.deleteById(id);
    }
}

