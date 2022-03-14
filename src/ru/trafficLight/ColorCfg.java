package ru.trafficLight;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@Configuration
public class ColorCfg {

    @Lazy
    @Bean
    public Color red(Color redYellow){
        return new Color("red", redYellow);
    }

    @Lazy
    @Bean
    public Color green(Color greenYellow){
        return new Color("green", greenYellow);
    }

    @Lazy
    @Bean
    public Color redYellow(Color green){
        return new Color("yellow", green);
    }

    @Lazy
    @Bean
    public Color greenYellow(Color red){
        return new Color("yellow", red);
    }

}
