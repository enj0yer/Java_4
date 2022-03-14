package ru.kulagin;

public class Box<T> {
    private T obj;

    Box(T obj){
        this.obj = obj;
    }

    public void setObj(T obj){
        if (obj != null) throw new IllegalStateException("Box is not empty");
        this.obj = obj;
    }

    public T getObj() {
        T res = obj;
        obj = null;
        return res;
    }

    public boolean isFull(){
        return obj != null;
    }
}
