package ru.kulagin.geometry;

public class Triangle extends Figure {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point first, Point second, Point third) {
        this.first = first.clone();
        this.second = second.clone();
        this.third = third.clone();
    }

    public double square() {
        double a = Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2));
        double b = Math.sqrt(Math.pow(second.getX() - third.getX(), 2) + Math.pow(second.getY() - third.getY(), 2));
        double c = Math.sqrt(Math.pow(third.getX() - first.getX(), 2) + Math.pow(third.getY() - first.getY(), 2));

        double halfPer = (a + b + c) / 2;

        return Math.sqrt(halfPer * (halfPer - a) * (halfPer - b) * (halfPer - c));

    }
}
