package ru.kulagin.geometry;

public class Rectangle extends Figure {
    private Point point;
    private double firstSide;
    private double secondSide;

    public Rectangle(Point point, double firstSide, double secondSide) {
        this.point = point.clone();
        if (firstSide < 0 && secondSide < 0) throw new IllegalArgumentException("Wrong side value");
    }

    public double square() {
        return firstSide * secondSide;
    }
}
