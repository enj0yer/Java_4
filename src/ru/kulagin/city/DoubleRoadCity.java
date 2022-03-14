package ru.kulagin.city;

import java.util.ArrayList;

public class DoubleRoadCity extends City{
    public DoubleRoadCity(String name){
        super(name);
    }
    public DoubleRoadCity(String name, ArrayList<Road> roads) {
        super(name, roads);
    }
    public void addRoad(Road r){
        roads.add(r);
        roads.add(new Road(r.getFinish(), r.getStart()));
    }
}
