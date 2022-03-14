package ru.kulagin.animals;

import java.util.Random;

public class Cuckoo extends Bird {
    public void sing() {
        int count = new Random().nextInt(10);
        for (int i = 0; i < count; i++) {
            System.out.println("ку-ку");
        }
    }
}
