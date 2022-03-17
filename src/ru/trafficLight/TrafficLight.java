package ru.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight {
    @Autowired
    @Qualifier("red")

    private Color currColor;

    public void next(){
        System.out.println(currColor.getColor());
        currColor = currColor.getNextColor();
    }

    private void changeState(){

    }
}
