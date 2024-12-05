package org.example;

import org.example.config.AppConfig;
import org.example.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.PrintStream;

/**
 * Hello world!
 *
 */
public class App 
{
    private static PrintStream out;

    public static void main(String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService bean = context.getBean(StudentService.class);
        bean.addStudent();
        bean.removeStudent();
    }
}
