package ru.kulagin.geometry;

import java.util.Objects;

public class Point3D extends Point {
    private double z;

    public Point3D(double x, double y, double z){
        super(x, y);
        this.z = z;
    }


    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getZ(){
        return z;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z){
        this.z = z;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(this.getClass() == obj.getClass())) return false;
        Point3D p = (Point3D) obj;
        double eps = 10e-5;
        return Math.abs(this.x - p.x) < eps && Math.abs(this.y - p.y) < eps && Math.abs(this.z - p.z) < eps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(z);
    }

    @Override
    public String toString(){
        return "{" + x + "; " + y + "; " + z + "} ";
    }

}
