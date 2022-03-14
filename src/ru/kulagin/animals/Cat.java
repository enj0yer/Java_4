package ru.kulagin.animals;

public class Cat implements Meowable{
    private String name;
    private int count;

    public Cat(String name){
        this.name = name;
    }
    public Cat(String name, int count){
        this(name);
        if (count < 1){
            this.count = 0;
        }
        else this.count = count;
    }

    public void meow(){
        System.out.println(name + ": мяу");
    }
    public void meow(int count){
        if (count == 0){
            this.meow();
        }
        else {
            String output = name + ": ";
            for (int i = 0; i < count; i++) {
                output += "мяу ";
            }
            System.out.println(output);
        }
    }

    @Override
    public String toString(){
        return "Кот: " + name;
    }
}

