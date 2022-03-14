package ru.kulagin.animals;

import java.util.Random;

public class Parrot extends Bird {

    private String text;

    public Parrot(String text) {
        this.text = text;
    }

    public void sing() {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1 && new Random().nextInt(10) < 3 && array[i] != ' ' && array[i + 1] != ' ') {
                char swapped = array[i];
                array[i] = array[i + 1];
                array[i + 1] = swapped;
            }
        }
        for (char el : array) {
            System.out.print(el);
        }
    }
}
