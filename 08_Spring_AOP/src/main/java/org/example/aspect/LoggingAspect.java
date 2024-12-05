package org.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //The annotation marks the class as an aspect.
@Component
public class LoggingAspect {
    @Before("execution(* org.example.service.StudentService.*(..))")//The annotation ensures that the logging logic runs before any method in the StudentService class.
    public void logBeforeMethodExecutions(){
        System.out.println("Logging :: A method of Student srevice is executed");
    }
}
