package org.example.service;

import org.example.Entity.Student;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;


    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String saveStudent(Student stu){
        return studentRepository.saveStudent(stu);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }


    public String updateStudentById(int id, Student updatedStudent) {
        return studentRepository.updateStudentById(id, updatedStudent);
    }


    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    public String deleteAllStudents() {
        return studentRepository.deleteAllStudents();
    }
}
