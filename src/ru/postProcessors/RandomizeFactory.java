package ru.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class RandomizeFactory implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();

        for (var beanName : beanNames){
            if (beanName.equals("random")){
                GenericBeanDefinition bd = new GenericBeanDefinition();
                bd.setBeanClass(Random.class);
                bd.setScope("prototype");
                bd.setAutowireCandidate(true);
                bd.setAutowireMode(1);

                BeanDefinitionRegistry registry = (BeanDefinitionRegistry) configurableListableBeanFactory;

                registry.registerBeanDefinition("random", bd);

            }
        }
    }
}

@Component
class Random{
    public int random(int min, int max){
        return (int)(Math.random() * (max - min) - min);
    }
}
