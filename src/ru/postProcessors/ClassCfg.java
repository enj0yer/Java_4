package ru.postProcessors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ClassCfg {

    @Bean
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }

    @Bean
    public Bird bird(){
        return new Bird();
    }

    @Bean
    public String string(){
        return "qwerty";
    }

    @Bean
    public int min(){
        return 0;
    }

    @Bean
    public int max(){
        return 100;
    }

//    @Bean
//    public Object object(){
//        return new Object();
//    }
}


@Component
class NullStringGen{

    @Override
    public String toString() {
        return null;
    }
}
