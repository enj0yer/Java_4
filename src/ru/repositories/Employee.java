package ru.repositories;


import org.springframework.data.annotation.Id;

public class Employee {

    @Id
    private int id_employee = 0;
    private String name;
    private int id_department;

    public Employee(int id_employee, String name, int id_department){
        this.id_employee = id_employee;
        this.name = name;
        this.id_department = id_department;
    }

    public Employee(String name, int id_department){
        this.name = name;
        this.id_department = id_department;
    }

    public Employee(){

    }

    public String getName() {
        return name;
    }

    public int getId_employee() {
        return id_employee;
    }

    public int getId_department() {
        return id_department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", name='" + name + '\'' +
                ", id_department=" + id_department +
                '}';
    }
}
