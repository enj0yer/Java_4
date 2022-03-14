package ru.kulagin.geometry;

public class Square extends Figure {
    private Point point;
    private double length;

    public Square(Point point, double length){
        if (length <= 0){
            throw new IllegalArgumentException("negative or zero length");
        }
        this.point = point.clone();
        this.length = length;
    }
    public Square(double x, double y, double length){
        this(new Point(x, y), length);
    }
    @Override
    public String toString(){
        return "Квадрат в точке " + point.toString() + " со стороной " + length;
    }

    public double getLength(){
        return length;
    }
    void setLength(double length){
        if (length <= 0){
            throw new IllegalArgumentException("negative or zero length");
        }
        this.length = length;
    }

    public BrokenLine toBrokenLine(){
        return new ClosedBrokenLine(point, new Point(point.getX() + length, point.getY()), new Point(point.getX() + length, point.getY() - length), new Point(point.getX(), point.getY() - length));
    }
    public double square(){
        return length * length;
    }
}
