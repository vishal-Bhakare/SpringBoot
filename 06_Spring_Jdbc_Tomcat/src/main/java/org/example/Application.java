package org.example;

import org.example.config.AppConfig;
import org.example.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "org.example")
public class Application {
    public static void main(String[] args) {
      /* ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(StudentController.class);*/
    }
}

