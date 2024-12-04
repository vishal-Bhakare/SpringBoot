package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello I am Main method....");

       ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurations.class);
        Car bean = applicationContext.getBean(Car.class);
        bean.drive();
    }
}
