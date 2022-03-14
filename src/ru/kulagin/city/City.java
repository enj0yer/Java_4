package ru.kulagin.city;

import java.util.ArrayList;

public class City {
    String name;
    ArrayList<Road> roads = new ArrayList<Road>();

    public City(String name){
        this.name = name;
    }

    public City(String name, ArrayList<Road> roads){
        this.name = name;
        this.roads = roads;


    }

    void setRoads(ArrayList<Road> roads){
        this.roads = roads;
    }

    void addRoad(Road r){
        roads.add(r);
    }

    public boolean equals(City c) {
        if (this.roads.size() != c.roads.size()){
            return false;
        }
        for (int i = 0; i < this.roads.size(); i++){
            if (this.roads.get(i).equals(c.roads.get(i))){
                return false;
            }
        }
        return true;
    }

    Road deleteRoad(int index){
        return roads.remove(index);
    }

    @Override
    public City clone(){
        return new City(this.name, this.roads);
    }

}
