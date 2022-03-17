package ru.trafficLight;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ColorCfg {

    @Bean
    public Color red(Color redYellow){
        return new Color("red", redYellow);
    }
    @Bean
    public Color green(Color greenYellow){
        return new Color("green", greenYellow);
    }

    @Bean
    public Color redYellow(Color green){
        return new Color("yellow", green);
    }

    @Bean
    public Color greenYellow(Color red){
        return new Color("yellow", red);
    }

}
