package ru.kulagin;

public enum Temperature {
    HOT(25, 60, "Жарко"), NORMAL(10, 25, "Нормально"), COLD(-50, 10, "Холодно");

    private int min;
    private int max;
    private String name;

    Temperature(int min, int max, String name){
        this.min = min;
        this.max = max;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "min=" + min +
                ", max=" + max +
                ", name='" + name + '\'' +
                '}';
    }
}
