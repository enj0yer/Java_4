package ru.trafficLight;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.trafficLight");

        TrafficLight tl = ctx.getBean(TrafficLight.class);

        tl.next();
        tl.next();
        tl.next();
        tl.next();
        tl.next();
    }
}
