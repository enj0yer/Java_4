package ru.kulagin.geometry;

public class ClosedBrokenLine extends BrokenLine {

    public ClosedBrokenLine(){
        this.points = null;
    }
    public ClosedBrokenLine(Point... points) {
        super(points.clone());
        if (!(points[0].getY() == points[points.length - 1].getY() && points[0].getX() == points[points.length - 1].getX())) {
            this.addPoints(points[0]);
        }
    }
}
