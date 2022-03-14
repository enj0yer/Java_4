package ru.kulagin.person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Name {

    private String surname;
    private String name;
    private String pat;

    public static class Generator{
        public static List<Name> names = new ArrayList<>();

        public static Name generate(String surname, String name, String pat){
            Name newName = new Name(surname, name, pat);
            Name n = names.stream().filter(x -> newName.name.equals(x.name) && newName.surname.equals(x.surname) && newName.pat.equals(x.pat)).findFirst().orElse(null);
            if (n != null) return n;
            names.add(newName);
            return newName;
        }
        public static Name generate(String surname, String name){
            Name newName = new Name(surname, name);
            Name n = names.stream().filter(x -> newName.name.equals(x.name) && newName.surname.equals(x.surname)).findFirst().orElse(null);
            if (n != null) return n;
            names.add(newName);
            return newName;
        }
        public static Name generate(String name){
            Name newName = new Name(name);
            Name n = names.stream().filter(x -> newName.name.equals(x.name)).findFirst().orElse(null);
            if (n != null) return n;
            names.add(newName);
            return newName;
        }
    }


    private Name(String name){
        String checkStr = surname + name + pat;
        if (checkStr.matches("(null){0,3}")){
            throw new IllegalArgumentException("Wrong value of surname or name or pat");
        }
        this.name = name;
    }
    private Name(String surname, String name){
        this(name);
        this.surname = surname;
    }
    private Name(String surname, String name, String pat){
        this(surname, name);
        this.pat = pat;
    }

//    public static Name generate(String surname, String name, String pat){
//        return new Name(surname, name, pat);
//    }
//    public static Name generate(String surname, String name){
//        return new Name(surname, name);
//    }
//    public static Name generate(String name){
//        return new Name(name);
//    }
    public String getSurname(){
        return surname;
    }

    public String getName(){
        return name;
    }

    public String getPat(){
        return pat;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(this.getClass() == obj.getClass())) return false;
        Name n = (Name) obj;
        if (n.surname.equals(this.surname) && n.name.equals(this.name) && n.pat.equals(this.pat)) return true;
        return false;
    }

    @Override
    public Name clone(){
        return new Name(surname, name, pat);
    }

    @Override
    public String toString(){
        return surname + " " + name + " " + pat + " ";
    }


}
