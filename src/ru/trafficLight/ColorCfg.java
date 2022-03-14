package ru.trafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColorCfg {

    @Bean
    public Color red(Color rYellow){
        return new Color("red", rYellow);
    }

    @Bean
    @Qualifier("startColor")
    public Color green(Color gYellow){
        return new Color("green", gYellow);
    }

    @Bean
    public Color rYellow(Color green){
        return new Color("yellow", green);
    }

    @Bean
    public Color gYellow(Color red){
        return new Color("yellow", red);
    }



}
