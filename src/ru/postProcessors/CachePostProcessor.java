package ru.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class CachePostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Annotation[] annotations = bean.getClass().getAnnotations();

        List<Method> methods;

        for (var annotation : annotations){
            if (annotation.annotationType() == Cache.class){
                if (Arrays.equals(((Cache) annotation).value(), new String[]{""})){
                    methods = Arrays.asList(bean.getClass().getDeclaredMethods());
                }
                else{
                    methods = Arrays.asList(bean.getClass().getDeclaredMethods());
                    String[] namesOfMethods = ((Cache) annotation).value();

                    List<Method> temp = new ArrayList<>(methods);

                    methods = new ArrayList<>();

                    for (var method : temp){
                        for (var name : namesOfMethods){
                            if (method.getName().equals(name)){
                                methods.add(method);
                                break;
                            }
                        }
                    }
                }
                try {
                    Field mapField = bean.getClass().getDeclaredField("cache");
                    mapField.setAccessible(true);
                    Map<String, Object> cacheMap = (Map<String, Object>) mapField.get(bean);

                    for (var method : methods){
                        Object result = method.invoke(bean);
                        cacheMap.put(method.getName(), result);
                    }

                    mapField.set(bean, cacheMap);
                } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {

                }
            }
        }
        return bean;
    }
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Cache{
    String[] value() default {""};
}
