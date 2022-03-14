package ru.kulagin.geometry;

public class Point implements Cloneable{

    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Point clone(){
        try {
            return (Point) super.clone();
        }
        catch (CloneNotSupportedException ex){
            throw new IllegalCallerException(ex);
        }
    }

    <T extends Point> double length(T p){
        double z1, z2;
        try{
            z1 = ((Point3D) p).getZ();
            z2 = ((Point3D) this).getZ();
        }
        catch (ClassCastException ex){
            z1 = 0;
            z2 = 0;
        }
        return Math.sqrt(Math.pow(p.getX() - this.getX(), 2) + Math.pow(p.getY() - this.getY(), 2) + Math.pow(z1 - z2, 2));
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(this.getClass() == obj.getClass())) return false;
        Point p = (Point) obj;
        double eps = 10e-5;
        return Math.abs(this.x - p.x) < eps && Math.abs(this.y - p.y) < eps;
    }

    @Override
    public String toString(){
        return "{" + x + "; " + y + "} ";
    }

}
