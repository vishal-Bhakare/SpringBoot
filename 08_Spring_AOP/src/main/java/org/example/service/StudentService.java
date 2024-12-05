package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class StudentService {

    public void addStudent(){
        System.out.println("Student Added.......");
    }

    public void removeStudent(){
        System.out.println("Student removed.....");
    }
}
