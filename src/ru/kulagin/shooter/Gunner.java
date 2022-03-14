package ru.kulagin.shooter;

public class Gunner {
    private String name;
    private Weapon gun;

    public Gunner(String name){
        this.name = name;
    }
    public Gunner(String name, Weapon gun){
        this.name = name;
        this.gun = gun;
    }

    public String getName() {
        return name;
    }

    public Weapon getGun() {
        return gun;
    }

    public void setGun(Weapon gun) {
        this.gun = gun;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void shoot(){
        if (gun == null){
            System.out.println("Не могу участвовать в перестрелке");
        }
        else{
            gun.shoot();
        }
    }
}

