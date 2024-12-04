package org.example;

public class Car {

    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive(){
        boolean status = engine.start();
        if (status){
            System.out.println("Engine started.......");
        }else {
            System.out.println("Engine failed....");
        }
    }
}
