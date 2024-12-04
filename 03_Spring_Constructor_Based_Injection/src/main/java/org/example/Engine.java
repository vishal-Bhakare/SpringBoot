package org.example;


import org.springframework.stereotype.Component;

@Component
public class Engine {

    public Engine() {
        System.out.println("Engine:: Constuctor......");
    }

    public boolean start() {
        System.out.println("Engine Ignited.....");
        return true;
    }
}
