package ru.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Green extends Color{
    @Autowired
    public Green(GreenYellow greenYellow){
        super("green", greenYellow);
    }

}
