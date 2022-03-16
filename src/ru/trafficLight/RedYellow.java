package ru.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class RedYellow extends Color{
    @Autowired
    public RedYellow(String color, Green green) {
        super(color, green);
    }

}
