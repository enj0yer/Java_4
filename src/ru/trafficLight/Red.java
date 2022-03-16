package ru.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Red extends Color{
    @Autowired
    public Red(String color, GreenYellow greenYellow) {
        super(color, greenYellow);
    }

}
