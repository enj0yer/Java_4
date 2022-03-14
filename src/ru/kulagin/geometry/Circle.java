package ru.kulagin.geometry;

public class Circle extends Figure {

    private Point centre;
    private double radius;

    public Circle(Point centre, double radius) {
        this.centre = centre.clone();
        if (radius < 0) throw new IllegalArgumentException("Wrong radius value");
        this.radius = radius;
    }

    public double square() {
        return 3.14 * radius * radius;
    }
}
