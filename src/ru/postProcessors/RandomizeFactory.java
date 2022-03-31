package ru.postProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class RandomizeFactory implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        BeanDefinitionRegistry bdr = (BeanDefinitionRegistry) configurableListableBeanFactory;

        GenericBeanDefinition randomConfigDefinition = new GenericBeanDefinition();

        randomConfigDefinition.setBeanClass(Random.class);

        bdr.registerBeanDefinition("Random", randomConfigDefinition);

        GenericBeanDefinition gbd = new GenericBeanDefinition(); //???????

        randomConfigDefinition.setFactoryBeanName("Random");
        randomConfigDefinition.setFactoryMethodName("random");
        randomConfigDefinition.setScope("prototype");
        randomConfigDefinition.setBeanClass(int.class);

        bdr.registerBeanDefinition("random", randomConfigDefinition);


    }
}

class Random{
    public int random(){
        return (int)(Math.random() * 100);
    }
}
