package ru.postProcessors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.postProcessors");

        A a = ctx.getBean(A.class);
        B b = ctx.getBean(B.class);
        C c = ctx.getBean(C.class);

        FieldPostProcessor fpp = ctx.getBean(FieldPostProcessor.class);

        fpp.postProcessAfterInitialization(a, a.getClass().getName());
        System.out.println(a.getName());
//        fpp.postProcessBeforeInitialization(a, a.getClass().getName());

        fpp.postProcessAfterInitialization(b, b.getClass().getName());
        System.out.println(b.getName());
//        fpp.postProcessBeforeInitialization(b, b.getClass().getName());

        fpp.postProcessAfterInitialization(c, c.getClass().getName());
        System.out.println(c.getName());
//        fpp.postProcessBeforeInitialization(c, c.getClass().getName());


    }
}
class A{
    private String name;

    public A(String obj){
        this.name = obj;
    }

    public String getName() {
        return name;
    }
}

class B{
    private Object name;

    public B(Object obj){
        this.name = obj;
    }

    public Object getName() {
        return name;
    }
}

class C{
    private Object name;

    public C(Object obj){
        this.name = obj;
    }

    public Object getName() {
        return name;
    }
}