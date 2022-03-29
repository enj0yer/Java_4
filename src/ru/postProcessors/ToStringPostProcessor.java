package ru.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class ToStringPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (checkBeanForAnnotation(bean) == -1){
            return bean;
        }

        Field[] fields = bean.getClass().getDeclaredFields();

        String toStringResult = beanName + "[ ";

        if (checkBeanForAnnotation(bean) == 1){
            for (var field : fields){
                field.setAccessible(true);
                try {
                    toStringResult += "{" + field.getName() + "::" + field.get(bean) + "} ";
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            toStringResult += "]";
            System.out.println(toStringResult);
        }
        else{
            for (var field : fields){
                field.setAccessible(true);
                if (field.isAnnotationPresent(ToString.class) && field.getAnnotation(ToString.class).value() == Bool.YES){
                    try {
                        toStringResult += "{" + field.getName() + "::" + field.get(bean) + "} ";
                    } catch (IllegalAccessException e) {

                    }
                }
            }
            toStringResult += "]";
            System.out.println(toStringResult);
        }

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private int checkBeanForAnnotation(Object bean){
        Annotation[] annotations = bean.getClass().getAnnotations();

        for (var annotation : annotations){
            if (annotation instanceof ToString){
                if (((ToString) annotation).value() == Bool.NO)
                    return -1;
                else return 1;
            }
        }

        Field[] fields = bean.getClass().getDeclaredFields();

        for(var field : fields){

            Annotation[] fAnnotations = field.getAnnotations();
            for (var fAnnotation : fAnnotations){
                if (fAnnotation instanceof ToString && ((ToString) fAnnotation).value() == Bool.YES){
                    return 0;
                }
            }
        }
        return -1;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@interface ToString{
    Bool value() default Bool.YES;
}

enum Bool{
    YES, NO
}

