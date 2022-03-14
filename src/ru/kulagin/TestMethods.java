package ru.kulagin;


import ru.kulagin.animals.Bird;
import ru.kulagin.animals.Meowable;
import ru.kulagin.geometry.*;

import java.math.BigInteger;
import java.security.Provider;
import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;

import static java.lang.Math.*;
import static java.lang.Double.*;

public class TestMethods {

    public static BigInteger sum(Number... numbers){
        BigInteger result = BigInteger.valueOf(0);
        for (Number value : numbers){
            result.add(BigInteger.valueOf(value.longValue()));
        }
        return result;
    }
    public static void meow(Meowable... cats){
        for (Meowable cat : cats){
            cat.meow();
        }
    }
    public static void sing(Bird... birds){
        for (Bird bird : birds){
            bird.sing();
        }
    }
    public static double square(Figure... figures){
        double result = 0;
        for (Figure figure : figures){
            result += figure.square();
        }
        return result;
    }
    public static double length(Lineable... lines){
        double result = 0;
        for (Lineable line : lines){
            result += line.length();
        }
        return result;
    }
    public BrokenLine toBrokenLine(Lineable... lines){
        ArrayList<Point> result = new ArrayList();
        for (Lineable line : lines){
            Point[] points = line.getPoints();
            for (Point point : points){
                result.add(point);
            }
        }
        return new BrokenLine(result.toArray(Point[]::new));
    }
    public double exp(String valueStr, String powerStr){
        double value = parseDouble(valueStr);
        double power = parseDouble(powerStr);

        return pow(value, power);
    }

    public static Line moveLine(Line line){
        double x = line.getStart().getX();

        Point p = line.getStart();

        if (line.getStart().getX() >= 0){
            p.setX(x + 10);
            return new Line(p, line.getFinish());
        }
        else {
            p.setX(x - 10);
            return new Line(p, line.getFinish());
        }
    }

    public static void startCount(Box<? extends Point> box){
        ((Box<Point3D>) box).setObj(new Point3D(1, 2, 4));
    }

    public static void fillList(List<? extends Number> list){
        for (int i = 1; i <= 100; i++){
            ((List<Number>)list).add((Number)i);
        }
    }


    public static double maxStorage(Storage<? extends Number>... storages){

        double max = ((Storage<Number>)storages[0]).getStorage(null).doubleValue();

        for (Storage el : storages) {
            if (((Storage<Number>) el).getStorage(null).doubleValue() > max) {
                max = ((Storage<Number>) el).getStorage(null).doubleValue();
            }
        }
        return max;
    }


    interface Applieble<T, P>{
        P apply(T obj);
    }

    public static <T, P> List<P> applier(List<T> lt,  Applieble<T, P> applier){

        List<P> lp = new ArrayList<>();

        for (T el : lt){
            lp.add((applier.apply(el)));
        }
        return lp;
    }


    interface Filterable<T>{
        boolean test(T obj);
    }

    public static <T> List<T> filter(List<T> l, Filterable<T> filter) {


        List<T> l2 = new ArrayList<>();

        for (T el : l) {
            if (filter.test(el)) {
                l2.add(el);
            }
        }
        return l2;
    }

    interface Reductable<T>{
        T reduct(T obj, T temp);
    }

    public static <T> T reduct(List<T> l, T t, Reductable<T> reductor){

        T temp = t;

        for (T value : l) {
            temp = reductor.reduct(value, temp);
        }
        return temp;
    }

    public interface Consumer<T, P>{
        void apply(T t, P p);
    }

    public interface Supplier<P>{
        P get();
    }

    public static <T, P> P collect(List<T> list, Consumer<T, P> consumer, Supplier<P> supplier){

        P col = supplier.get();

        for (T el : list){
            consumer.apply(el, col);
        }

        return col;
    }
}
