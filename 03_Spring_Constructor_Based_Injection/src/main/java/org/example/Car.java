package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive(){

        boolean status = engine.start();

        if(status){
            System.out.println("Engine Started......");
        }else {
            System.out.println("Engine Failed......");
        }


    }

}
