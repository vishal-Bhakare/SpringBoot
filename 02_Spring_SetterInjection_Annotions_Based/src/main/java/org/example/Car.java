package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Engine eng;
    @Autowired
    public void setEng(Engine eng) {
        this.eng = eng;
    }
    public void drive() {
        boolean status = eng.start();
        if(status){
            System.out.println("Engine started......");
        }else {
            System.out.println("Engine failed....");
        }
    }
}
