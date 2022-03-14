//package ru.kulagin;
//
//public class Point {
//    protected int x, y;
//    private Point(int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//    public static Point bulder(int x, int y){
//        return new Point(x, y);
//    }
//    public static Point3D bulder(int x, int y, int z){
//        return new Point3D(x, y, z);
//    }
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//    private static class Point3D extends Point{
//        private int z;
//        private Point3D(int x, int y, int z){
//            super(x, y);
//            this.z = z;
//        }
//
//        @Override
//        public String toString() {
//            return "Point3D{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    ", z=" + z +
//                    '}';
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Point{" +
//                "x=" + x +
//                ", y=" + y +
//                '}';
//    }
//}
