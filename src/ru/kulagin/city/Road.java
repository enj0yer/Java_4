package ru.kulagin.city;

import java.util.Objects;

public class Road {
    City start;
    City finish;

    public Road(City start, City finish){
        this.start = start;
        this.finish = finish;
        this.start.roads.add(this);
        this.finish.roads.add(this);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(this.getClass() == obj.getClass())) return false;
        Road r = (Road) obj;
        return Objects.equals(this.start.name, r.start.name) && Objects.equals(this.finish.name, r.finish.name);
    }

    public City getStart(){
        return start.clone();
    }
    public City getFinish(){
        return finish.clone();
    }

}
