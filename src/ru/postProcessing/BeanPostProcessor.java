package ru.postProcessing;

public interface BeanPostProcessor {
    void postProcessBeforeInit();
    void postProcessAfterInit();
}
