package ru.kulagin.department;

public class Department{
    String name;
    Employee boss;

    public Department(String name, Employee boss){
        this.name = name;
        this.boss = boss;
        boss.makeBoss(this);
    }
}