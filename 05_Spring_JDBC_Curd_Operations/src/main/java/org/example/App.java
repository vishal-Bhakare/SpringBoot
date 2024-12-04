package org.example;

import org.example.Entity.Student;
import org.example.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the StudentController bean
        StudentController studentController = context.getBean("studentController", StudentController.class);

       //delete All Student
        studentController.deleteAllStudents();
        // Add students
        Student student1 = new Student(101,"VISHAL","vishal1998@gamil.com","DEV",26);
        studentController.saveStudent(student1);
        Student student2 = new Student(102,"Saurabh","saurabh1998@gamil.com","DEV",36);
        studentController.saveStudent(student2);
        Student student3 = new Student(103,"SAHIL","sahil1998@gamil.com","DEV",16);
        studentController.saveStudent(student3);
        Student student4 = new Student(104,"Om","Om1998@gamil.com","DEV",26);
        studentController.saveStudent(student4);
        Student student5 = new Student(105,"Akshay","akshay1998@gamil.com","DEV",26);
        studentController.saveStudent(student5);
        System.out.println("Data Added sussfully....");


         // Fetch all students
        List<Student> students = studentController.getAllStudents();
        students.forEach(student -> System.out.println(student));

        // Get student by ID
        Student fetchedStudent = studentController.getStudentById(70);
        System.out.println(fetchedStudent);


        // Update a student by ID
        int studentIdToUpdate = 58;
        Student updatedStudent = new Student(studentIdToUpdate, "XXX", "XXX@egamil.com", "ZZZZ", 30);
        String updateMessage = studentController.updateStudentById(studentIdToUpdate, updatedStudent);
        System.out.println(updateMessage);
        // Fetch all students to verify the update
        studentController.getAllStudents().forEach(System.out::println);

        // Delete student
        studentController.deleteStudent(60);





    }
}
