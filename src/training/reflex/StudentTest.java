package training.reflex;

import com.company.Student;

public class StudentTest {
    public static void nameTest(Student student) throws IllegalStateException{
        if (!(student.getName().length() >= 2 && student.getName().length() <= 20))
            throw new IllegalStateException("Wrong student name");
    }
    public static void ageTest(Student student) throws IllegalStateException{
        if (!(student.getAge() >= 18 && student.getAge() <= 24))
            throw new IllegalStateException("Wrong student age");
    }
}
