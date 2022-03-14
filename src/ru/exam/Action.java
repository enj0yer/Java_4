package ru.exam;

public interface Action<T, R>{
    void act(T item, R wallet);
}
