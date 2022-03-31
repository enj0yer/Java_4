package ru.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class ValidatePostProcessor implements BeanPostProcessor {

    @Autowired
    private Tests tests;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean.getClass().isAnnotationPresent(Validate.class)){
            Field[] fields = bean.getClass().getDeclaredFields();
            List<Method> actualTests = new ArrayList<>();

            Validate annotation = bean.getClass().getAnnotation(Validate.class);
            String[] rules = annotation.value();
            Method[] testsMethods = tests.getClass().getDeclaredMethods();
            for (var testMethod : testsMethods){
                for (var rule : rules){
                    if (testMethod.getName().equals(rule))
                        actualTests.add(testMethod);
                }
            }

            for (var field : fields){
                for (var test : actualTests){
                    try {
                        test.invoke(tests, field, bean);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return bean;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface Validate{
    String[] value();
}

@Component
class Tests{
    public void isNotNull(Field field, Object object) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.get(object) == null) throw new IllegalStateException("Value of " + field.getName() + " is null");
    }

    public void isNotString(Field field, Object bean){
        field.setAccessible(true);
        if (field.getType() == String.class)
            throw new IllegalStateException("Type of " + field.getName() + " is String");
    }

    public void stringIsNotLong(Field field, Object object) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.get(object).getClass() == String.class && ((String)field.get(object)).length() >= 10){
            throw new IllegalStateException("Length of " + field.getName() + " is " + ((String)field.get(object)).length() + ", max length is 10");
        }
        else if (field.get(object).getClass() != String.class){
            throw new IllegalArgumentException("Field type " + field.getType().getName() + " is incorrect");
        }
    }

    public void isNull(Field field, Object object) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.get(object) != null) throw new IllegalStateException("Value of " + field.getName() + " is not null");
    }
}
