package ru.postProcessors;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.postProcessors");

        System.out.println(ctx.getBean(Random.class));
    }
}

@Component
@Validate({"isNull"})
class Cat{

//    private Map<String, Object> cache = new HashMap<>();

    private String string;
    private Dog dog;

    public Cat(){};

    public String getString() {
        return string;
    }

    public Dog getDog() {
        return dog;
    }

//    public Map<String, Object> getCache() {
//        return cache;
//    }

    @Override
    public String toString() {
        return "Cat{" +
                "string='" + string + '\'' +
                ", dog=" + dog +
                '}';
    }
}
@Component
@Validate({"isNull"})
class Dog{

//    private Map<String, Object> cache = new HashMap<>();

    private String string;
    private Cat cat;

    public Dog(){};

    public String getString() {
        return string;
    }

    public Cat getCat() {
        return cat;
    }

//    public Map<String, Object> getCache() {
//        return cache;
//    }

    @Override
    public String toString() {
        return "Dog{" +
                "string='" + string + '\'' +
                ", cat=" + cat +
                '}';
    }
}


@Component
@Validate({"isNull"})
class Bird{

//    private Map<String, Object> cache = new HashMap<>();

    private Dog dog;

    public Bird(){}

    public Dog getDog() {
        return dog;
    }

    public Object getName() {
        return dog;
    }

//    public Map<String, Object> getCache() {
//        return cache;
//    }

    @Override
    public String toString() {
        return "Bird{" +
                "dog=" + dog +
                '}';
    }
}
