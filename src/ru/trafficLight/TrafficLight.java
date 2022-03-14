package ru.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight {
    @Autowired
    @Qualifier("startColor")
    private Color color;

    public void next(){
        System.out.println(color.getColor());
        color = color.getNextColor();
    }
}
