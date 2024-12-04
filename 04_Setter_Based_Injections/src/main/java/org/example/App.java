package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello I am Main Method.......");
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        Car bean = context.getBean(Car.class);
        bean.drive();
    }
}
