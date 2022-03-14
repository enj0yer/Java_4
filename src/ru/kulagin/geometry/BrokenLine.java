package ru.kulagin.geometry;

import java.util.Arrays;
import java.util.List;

public class BrokenLine implements Lineable {
    protected Point[] points;

    public BrokenLine(Point... points){
        this.points = points.clone();
    }

    public void addPoints(Point... points){
        List<Point> var;
        var = Arrays.asList(points.clone());
        for (Point el : points){
            var.add(el);
        }
        this.points = var.toArray(Point[]::new);
    }
    public double length(){
        double result = 0;
        for (int i = 0; i < points.length; i++){
            if (i - 1 > 0){
                result += new Line(points[i], points[i - 1]).length();
            }
        }
        return result;
    }

    public Point[] getPoints() {
        return points.clone();
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(this.getClass() == obj.getClass())) return false;
        BrokenLine l = (BrokenLine) obj;
        if (this.points.length != l.points.length){
            return false;
        }
        for (int i = 0; i < this.points.length; i++){
            if (this.points[i].equals(l.points[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String output = "Линия [";
        for (Point el : points){
            output += " " + el.toString() + " ";
        }
        return output;
    }

}

