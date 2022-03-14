package com.company;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String str = "";

        Scanner sc = new Scanner(System.in);

        while (true){
            str = sc.next();

            if (str.equals("exit")) break;

            System.out.println(doSmth(str));
        }
    }

    public static String doSmth(String str) {
        String[] params = str.split("/");

        if (params.length < 2){
            return "Wrong input";
        }

        for (int i = 0; i < params.length; i++){
            params[i] = params[i].trim();
        }
        String args = "";
        for (int i = 1; i < params.length; i++){
            args += params[i];
        }
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.company");
        try{
            return ctx.getBean(params[0], Program.class).get(args);
        } catch (org.springframework.beans.BeansException ex){
            return "Program is not found";
        }

    }
}

interface Program{
    String get(String str);
}


