package ru.postProcessors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ClassCfg {

    @Bean
    public A a(NullStringGen obj){
        return new A(obj.toString());
    }

    @Bean
    public B b(C c){
        return new B(c);
    }

    @Bean
    public C c(A a){
        return new C(a);
    }
}

@Component
class NullStringGen{

    @Override
    public String toString() {
        return null;
    }
}
