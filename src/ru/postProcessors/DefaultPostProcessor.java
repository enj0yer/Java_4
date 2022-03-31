package ru.postProcessors;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Component
public class DefaultPostProcessor implements BeanPostProcessor {

    @Autowired
    ApplicationContext ctx;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Field[] fields = bean.getClass().getDeclaredFields();

        if (bean.getClass().isAnnotationPresent(Default.class)){
            for (var field : fields){
                field.setAccessible(true);
                try {
                    field.set(bean, ctx.getBean(field.getType()));
                } catch (IllegalAccessException e) {

                }
            }
        }
        else{
            for (var field : fields){
                field.setAccessible(true);
                try {
                    if (field.isAnnotationPresent(Default.class)){
                        field.set(bean, ctx.getBean(field.getType()));
                    }
                } catch (IllegalAccessException e) {

                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@interface Default{}