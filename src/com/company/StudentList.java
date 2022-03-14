package com.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class StudentList {

    @Bean
    public Student stud1(Iter itr){
        return new Student("petya", itr.next());
    }

    @Bean
    public Student stud2(Iter itr){
        return new Student("sergei", itr.next());
    }

    @Bean
    public Student stud3(Iter itr){
        return new Student("ivan", itr.next());
    }
}

@Component
class Iter{
    private int counter = 0;

    public int next(){
        return counter++;
    }

}

