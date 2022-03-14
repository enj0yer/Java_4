package ru.exam;


import java.util.List;

public class Item{
    private String name;
    private int value;
    private List<Robot> robots;

    public Item(String name, int value, List<Robot> robots){
        if (value <= 0) throw new IllegalArgumentException("Illegual value of " + value);
        this.name = name;
        this.value = value;
        this.robots = robots;
    }

    public int getValue(){
        return value;
    }

    public String getName(){
        return name;
    }

    public void changeValue(int value){
        if (value <= 0) throw new IllegalArgumentException("Illegual value of " + value);
        this.value = value;
        for (var robot : robots){
            robot.check(this);
        }
    }

    public List<Robot> getRobots(){
        return robots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return value == item.value;
    }
}
