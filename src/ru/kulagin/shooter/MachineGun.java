package ru.kulagin.shooter;

public class MachineGun extends Gun{
    private int rateOfFire;

    public MachineGun(){
        super(30, 30);
        rateOfFire = 30;
    }
    public MachineGun(int max){
        super(max, max);
        rateOfFire = max / 2;
    }

    public MachineGun(int max, int rateOfFire){
        super(max, max);
        this.rateOfFire = rateOfFire;
    }

    public void shoot(){
        for (int i = 0; i < rateOfFire; i++){
            if (count > 0){
                System.out.println("Бах");
                count--;
            }
            else System.out.println("Клац");
        }
    }
    public void shoot(int time){
        for (int i = 0; i < rateOfFire * time; i++){
            if (count > 0){
                System.out.println("Бах");
                count--;
            }
            else System.out.println("Клац");
        }
    }

}
