package ru.trafficLight;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.NonNull;

public class Color {
    private String currColor;
    private Color nextColor;

    public Color(String color, Color nextColor){
        this.currColor = color;
        this.nextColor = nextColor;
    }

    public String getColor(){
        return currColor;
    }

    public void setColor(String color){
        this.currColor = color;
    }

    public Color getNextColor() {
        return nextColor;
    }

    public void setNextColor(Color nextColor) {
        this.nextColor = nextColor;
    }


}
