package ru.kulagin.student;


import ru.kulagin.Compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

interface Consumer<T>{
    boolean apply(T t);
}

public class Student implements Compare<Student>, Comparable<Student> {
    private String name;
    private List<Integer> rating;

    public Student(String name, Consumer<Integer> consumer, Integer... rating){
        this.name = name;
        for (int el : rating) {
            if (consumer.apply(el)){
                this.rating.add(el);
            }
        }
        this.rating = Arrays.asList(rating);
    }

    public double average(){
        if (rating.size() == 0) return 0;
        else {
            double res = 0;
            for (int el : rating){
                res += el;
            }
            return res / rating.size();
        }
    }

    public void addMark(int mark){
        if (mark < 2 || mark > 5) throw new IllegalArgumentException("mark is out of range");
        this.rating.add(mark);
    }

    public void deleteMark(int index){
        if (index > rating.size() - 1 || index < 0) throw new IllegalArgumentException("index is out of range");
        rating.remove(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

//    private boolean isExcellent(){
//        return this.average() == 5;
//    }

    public ArrayList<Integer> getRating(){
        if (rating == null){
            return new ArrayList<>();
        }
        return new ArrayList<>(rating);
    }

    public void setRating(Integer... rating){
//        for (Integer mark : rating){
//            if (mark < 2 || mark > 5) throw new IllegalArgumentException("rating values is out of range");
//        }
        this.rating = new ArrayList<>(Arrays.asList(rating));
    }

    @Override
    public int compare(Student student){
        if (this.average() > student.average()) return 1;
        else if (this.average() == student.average()) return 0;
        return -1;
    }

    @Override
    public int compareTo(Student student) {
        return compare(student);
    }

    @Override
    public String toString(){
        if (rating.size() == 0){
            return name;
        }
        String output = name + ": [";
        for (int i = 0; i < rating.size(); i++){
            if (i == 0){
                output += rating.get(i);
            }
            else output += ", " + rating.get(i);
        }
        output += "]";

        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(rating, student.rating);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, isExcellent());
//    }
}

