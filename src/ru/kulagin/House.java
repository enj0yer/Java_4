package ru.kulagin;

public class House {

    private int floors;

    public House(int floors){
        if (floors <= 0){
            throw new IllegalArgumentException("the value of the floors is zero or negative");
        }
        else this.floors = floors;

    }

    public int getFloors(){
        return floors;
    }

    @Override
    public String toString(){
        int lastNum = floors;

        while (lastNum / 10 > 0){
            lastNum %= 10;
        }

        return "Дом с " + floors + ((lastNum == 1) ? " этажом" : " этажами");
    }

}
