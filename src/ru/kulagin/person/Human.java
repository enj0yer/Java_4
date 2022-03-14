package ru.kulagin.person;

public class Human {

    private String name;
    private int height;
    private int age;

    public Human(String name, int age, int height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        String output = name;
        if (height < 160){
            output += " имеет маленький рост";
        }
        else if (height > 185){
            output += " имеет большой рост";
        }
        else output += " имеет средний рост";
        return output;
    }

}
