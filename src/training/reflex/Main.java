package training.reflex;


import com.company.Student;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Student st = new Student("Ivan", 20);

        Utility.validate(st, StudentTest.class);
    }
}
