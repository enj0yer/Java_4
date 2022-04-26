package ru.repositories;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.relational.core.sql.In;

import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.repositories");

        Scanner in = new Scanner(System.in);

        System.out.println("Приложение запущено");

        while (true){
            String result = in.nextLine().toLowerCase(Locale.ROOT);
            int id = 0;
            int dep_id = 0;
            String name = "";

            switch (result) {
                case "add":
                    System.out.println("Введите имя нового Employee");
                    name = in.nextLine();
                    System.out.println("Введите id отдела Employee");
                    dep_id = in.nextInt();
                    ctx.getBean(EmployeeRepository.class).save(new Employee(name, dep_id));
                    break;
                case "delete":
                    System.out.println("Введите id для удаления");
                    id = in.nextInt();
                    ctx.getBean(EmployeeRepository.class).deleteById(id);
                    break;
                case "show":
                    System.out.println(ctx.getBean(EmployeeRepository.class).findAll());
                    break;
                case "show with department name":
                    System.out.println(ctx.getBean(EmployeeRepository.class).findEmployeesWithNamedDepartments());
                    break;
                case "get all in department":
                    System.out.println("Введите id нужного отдела");
                    dep_id = in.nextInt();
                    System.out.println(ctx.getBean(EmployeeRepository.class).findEmployeesWithDepartment(dep_id));
                    break;
                case "exit":
                    System.out.println("Приложение остановлено");
                    System.exit(0);
            }
        }
    }
}
