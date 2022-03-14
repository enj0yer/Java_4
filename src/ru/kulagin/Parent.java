package ru.kulagin;

public class Parent<T extends Number> implements Observer<T>{

    private String name;

    public Parent(String name){
        this.name = name;
    }

    public void check(T mark){
        if (mark.doubleValue() > 2) System.out.println(name + ": Молодец");
        else System.out.println(name + ": Плохо");
    }

}
