package ru.trafficLight;


public class Color {
    protected String currColor;
    protected Color nextColor;

    public Color(String color, Color nextColor){
        this.currColor = color;
        this.nextColor = nextColor;
    }

    public Color(String color){
        this.currColor = color;
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
