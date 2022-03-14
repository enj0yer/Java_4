package ru.kulagin.shooter;

public class Gun extends Weapon{

    final protected int maxCount;

    public Gun(int count, int maxCount){
        if (count > maxCount) throw new IllegalArgumentException("maxCount is bigger than count");
        this.count = count;
        this.maxCount = maxCount;
    }
    public Gun(int count){
        this(count, count);
    }
    public Gun(){
        this(5, 5);
    }

    public int toEmpty(){
        return this.count;
    }

    public int getMaxCount(){
        return maxCount;
    }
    public int reload(int count){
        if (count < 0) {
            throw new IllegalArgumentException("count is negative");
        }
        if (count + this.count <= maxCount) return 0;

        return count - (maxCount - this.count);
    }
    public int currCount(){
        return count;
    }
    public boolean isLoaded(){
        return count > 0;
    }

    public void shoot(){
        if (count > 0 ){
            System.out.println("Бах");
            count--;
        }
        else System.out.println("Клац");
    }
}
