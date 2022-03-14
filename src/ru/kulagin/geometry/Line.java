package ru.kulagin.geometry;


public class Line<T extends Point> implements Lineable, Cloneable {

    private T start;
    private T finish;

    public Line(Point start, Point finish){
        if (start.getClass() != finish.getClass()) throw new IllegalArgumentException("Points types is not equal");
        this.start = (T) start.clone();
        this.finish = (T) finish.clone();
    }

    private Line (double x1, double y1, double x2, double y2){
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public static  Line<Point> newLine(double x1, double y1, double x2, double y2){
        return new Line<Point>(x1, y1, x2, y2);
    }

    public double length(){
        return start.length(finish);
    }

    public T getStart(){
        return (T) start.clone();
    }

    public T getFinish(){
        return (T) finish.clone();
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{(T) this.start.clone(), (T) this.finish.clone()};
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(this.getClass() == obj.getClass())) return false;
        Line<T> l = (Line<T>) obj;
        return this.start.equals(l.start) && this.finish.equals(l.finish);
    }

    @Override
    public Line clone(){
        return new Line<T>((T) this.start.clone(), (T) this.finish.clone());
    }

    @Override
    public String toString(){
        return "Линия от {" + start.getX() + ": " + start.getY() + "} до {" + finish.getX() + ":" + finish.getY() + "}";
    }

}
