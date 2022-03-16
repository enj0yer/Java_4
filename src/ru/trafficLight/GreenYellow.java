package ru.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class GreenYellow extends Color{

    @Autowired
    public GreenYellow(String color, Color red) {
        super(color, red);
    }

}
