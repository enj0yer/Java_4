package ru.trafficLight;

public class Color {
    private String color;
    private Color nextColor;

    public Color(String color, Color nextColor){
        this.color = color;
        this.nextColor = nextColor;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public Color getNextColor() {
        return nextColor;
    }

    public void setNextColor(Color nextColor) {
        this.nextColor = nextColor;
    }


}
