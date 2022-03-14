package ru.kulagin.shooter;

public abstract class Weapon {

    protected int count;

    abstract void shoot();

    public int currCount(){
        return count;
    }
    public void load(int ammo){
        if (ammo < 0) throw new IllegalArgumentException("Wrong ammo value");
        count += ammo;
    }
    public boolean isLoaded(){
        if (count == 0) return false;
        return true;
    }

}
