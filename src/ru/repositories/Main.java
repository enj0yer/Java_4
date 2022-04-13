package ru.repositories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.repositories");



        Scanner in = new Scanner(System.in);

        while (true){

            System.out.println("Введите add для добавления Employee или delete для удаления");
            String result = in.nextLine().toLowerCase(Locale.ROOT);

            switch (result) {
                case "add":
                    System.out.println("Введите имя нового Employee");
                    String name = in.nextLine();
                    System.out.println("Введите id отдела Employee");
                    int dep_id = in.nextInt();
                    ctx.getBean(EmployeeRepository.class).save(new Employee(name, dep_id));
                    break;
                case "delete":
                    System.out.println("Введите id для удаления");
                    int id = in.nextInt();
                    ctx.getBean(EmployeeRepository.class).deleteById(id);
                    break;
                case "show":
                    System.out.println(ctx.getBean(EmployeeRepository.class).findAll());
                    break;
                case "exit":
                    System.exit(0);
                case "info":
                    System.out.println("Введите add для добавления Employee или delete для удаления");
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }


    }
}
