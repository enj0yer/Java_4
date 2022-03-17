package ru.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class FieldPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        try{
            Field f = bean.getClass().getDeclaredField("name");
            f.setAccessible(true);
            if (f.getType() == String.class && f.get(bean) == null){
                f.set(bean, "vasya");
            }
        } catch (NoSuchFieldException | IllegalAccessException ex){

        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }
}
