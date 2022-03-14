package ru.kulagin;

public class Security {

    public void check(Prep p){
        System.out.println("Welcome");
    }

    public void check(Student s){
        if (s.getName() != null){
            System.out.println("Welcome");
        }
        else{
            System.out.println("Wrong");
        }
    }

    public void check(Human h){
        System.out.println("Wrong");
    }
}
