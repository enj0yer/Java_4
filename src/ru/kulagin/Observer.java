package ru.kulagin;

public interface Observer<T> {
    void check(T value);
}
