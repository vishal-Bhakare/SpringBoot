package org.example;


import org.springframework.stereotype.Component;

@Component
public class Engine {
    public Engine() {
        System.out.println("Constructor:: Engine Class....");
    }
    public boolean start() {
        System.out.println("Engine Iginted.....");
        return true;
    }
}
