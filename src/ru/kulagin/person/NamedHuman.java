package ru.kulagin.person;

public class NamedHuman {

    private Name name;
    private String stringName;
    private int height;
    private NamedHuman father;

    public NamedHuman(Name name, int height){
        if (height > 500){
            throw new IllegalArgumentException("height is too big");
        }
        this.name = name.clone();
        this.height = height;
    }

    public NamedHuman(Name name, int age, NamedHuman father){
        this(name, age);
        this.father = father;
        this.name = Name.Generator.generate(this.name.getSurname(), this.name.getName(), father.name.getPat() + "ович");
    }

    public NamedHuman(String stringName, int height){
        this(Name.Generator.generate(stringName), height);
    }

    public NamedHuman(String stringName, int height, NamedHuman father){
        this(Name.Generator.generate(stringName), height, father);
    }

    public Name getName(){
        return name.clone();
    }

    public NamedHuman getFather(){
        return father;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        if (height > 500){
            throw new IllegalArgumentException("height is too big");
        }
        this.height = height;
    }

    @Override
    public String toString() {

        if (name.getSurname().equals("") && father != null && !father.name.getSurname().equals("")){
            this.name = Name.Generator.generate(this.name.getSurname(), father.name.getSurname(), this.name.getPat());
        }
        if (name.getPat().equals("") && father != null){
            this.name = Name.Generator.generate(this.name.getSurname(), this.name.getName(), father.name.getName() + "ович");
        }
        String output = name.toString();
        if (height < 160) {
            output += " имеет маленький рост";
        } else if (height > 185) {
            output += " имеет большой рост";
        } else output += " имеет средний рост";
        return output;

    }
}
