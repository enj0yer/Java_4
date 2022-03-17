package ru.trafficLight;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.trafficLight");

        TrafficLight tl = ctx.getBean(TrafficLight.class);

        for (int i = 0; i < 100; i++){
            tl.next();
        }
    }
}
