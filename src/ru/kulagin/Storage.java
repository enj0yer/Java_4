package ru.kulagin;

public class Storage<T> {
    final private T obj;
    private static boolean counter = false;

    public Storage(T obj){
        this.obj = obj;
    }
//    public Storage(T obj){
//        if (obj == null) throw new IllegalArgumentException("obj can't be null");
//        this.obj = obj;
//    }

//    public static <T> Storage<T> newStorage(T obj, T alt){
//        if (!counter && obj == null){
//            counter = true;
//            return new Storage<T>(obj, alt);
//        }
//        else if(counter && obj == null){
//            throw new IllegalArgumentException("obj can't be null");
//        }
//        else{
//            return new Storage<>(obj, alt);
//        }
//    }

    public T getStorage(T alt) {
        return obj != null ? obj : alt;
    }
}
