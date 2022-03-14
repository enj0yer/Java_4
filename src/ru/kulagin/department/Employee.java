package ru.kulagin.department;

public class Employee {
    private String name;
    private boolean isBoss = false;
    private Department department;

    public Employee(String name, Department department){
        this.name = name;
        this.department = department;
    }

    public void makeBoss(Department department){
        isBoss = true;
        this.department = department;
    }
    public void makeNotBoss(Department department){
        isBoss = false;
        this.department = department;
    }
}