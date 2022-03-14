package ru.exam;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private int money;
    private List<Item> list = new ArrayList<>();

    public Wallet(int money){
        if (money <= 0) throw new IllegalArgumentException("Illegal value of " + money);
        this.money = money;
    }

    public void buy(Item item, int value){
        int count = value / item.getValue();
        if (count * item.getValue() >= money){
            System.out.println("Недостаточно денег на счету{" + "необходимо: " + count * item.getValue() + ", в наличии: " + money);
        }
        for (int i = 0; i < count; i++){
            list.add(new Item(item.getName(), item.getValue(), item.getRobots()));
        }
        System.out.println("Было куплено " + count + " акций с названием " + item.getName());
    }

    public void sell(Item item, int value){
        int counter = 0;
        for (int i = 0; i < list.size();){
            if (counter == value){
                break;
            }
            if (list.get(i).equals(item)){
                counter++;
                list.remove(i);
            }
            i++;
        }
        if (list.size() == 0){
            System.out.println("Акции отсутствуют");
        }
        else if (counter == 0){
            System.out.println("Не было продано ни одной акции");
        }
        else{
            System.out.println("Было продано " + counter + " акций с названием " + item.getName());
        }
    }

    public List<Item> getItems(){
        return list;
    }
}
