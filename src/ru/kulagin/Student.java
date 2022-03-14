package ru.kulagin;


import java.util.*;

interface Predicate<T extends Number>{
    boolean check(T mark);
}
class Prep extends Human{
    void visit(Security s){
        s.check(this);
    }
}
class Human{
    String name;
    void visit(Security s){
        s.check(this);
    }
}

enum Rule{
    POZITIVE(x -> x.doubleValue() > 0),
    NORMAL(x -> x.doubleValue() >= 2 && x.doubleValue() <= 5),
    HUNDRED(x -> x.doubleValue() >= 1 && x.doubleValue() <= 100),
    TRUE(x -> true);

    private Predicate rule;

    Rule(Predicate rule){
        this.rule = rule;
    }

    public boolean check(Number mark){
        return rule.check(mark);
    }
}

interface Actionable<T>{
    void action();
}

public class Student<T extends Number> extends Human implements Compare<Student>, Comparable<Student>{
    private String name;
    private List<T> rating = new ArrayList<>();
    private Rule rule;
    private Deque<Actionable> history = new ArrayDeque();
    private CareTaker ct = new CareTaker();
    private List<Observer> parents = new ArrayList<>();

    public Student(){}

    public Student(String name, Rule rule, T... rating){
        this.name = name;
        this.rule = rule;
        for (T el : rating) {
            if (this.rule.check(el)){
                this.rating.add(el);
            }
            else throw new IllegalArgumentException("Marks is out of range");
        }
    }

    @Override
    void visit(Security s) {
        s.check(this);
    }

    public Student<T> undo(){
        history.pop().action();
        return this;
    }

    public void save(){
        ct.addSnap(new Snapshot<T>(name, new ArrayList<T>(rating)));
    }

    public Student<T> load(int index){
        if (index >= ct.snapshots.size()){
            throw new IllegalArgumentException("Index is " + index + ". Max allowed value is " + ct.snapshots.size());
        }
        for (int i = 0; i <= index; i++){
            Snapshot<T> s = ct.getSnap();
            this.name = s.name;
            this.rating = s.rating;
        }
        return this;
    }

    public Student(String name, T... rating){
        this(name, Rule.TRUE, rating);
    }


    private class Snapshot<T>{
        private String name;
        private List<T> rating;

        Snapshot(String name, List<T> rating){
            this.name = name;
            this.rating = new ArrayList<>(rating);
        }
    }

    private class CareTaker{
        private Deque<Snapshot<T>> snapshots = new ArrayDeque<>();

        void addSnap(Snapshot<T> s){
            snapshots.push(s);
        }

        Snapshot<T> getSnap(){
            return snapshots.pop();
        }
    }

    public double average(){
        if (rating.size() == 0) return 0;
        else {
            double res = 0;
            for (T el : rating){
                res += el.doubleValue();
            }
            return res / rating.size();
        }
    }

    public void addParent(Observer<T> p){
        parents.add(p);
    }

    public void addMark(T mark){
        if (rule.check(mark)){
            for (Observer parent : parents) {
                parent.check(mark);
            }
            this.rating.add(mark);
            history.push(() -> rating.remove(mark));
        }
        else throw new IllegalArgumentException("mark is out of range");
    }

    public void deleteMark(int index){
        if (index > rating.size() - 1 || index < 0) throw new IllegalArgumentException("index is out of range");
        T oldMark = rating.get(index);
        history.push(() -> rating.remove(oldMark));
        rating.remove(index);
    }
                                                                                                 
    public String getName() {
        return name;
    }

    public void setName(String name){
        String oldName = this.name;
        history.push(() -> setName(oldName));
        this.name = name;
    }

//    private boolean isExcellent(){
//        return this.average() == 5;
//    }

    public ArrayList<T> getRating(){
        if (rating == null){
            return new ArrayList<>();
        }
        return new ArrayList<>(rating);
    }

//    public void setRating(T... rating){
////        for (Integer mark : rating){
////            if (mark < 2 || mark > 5) throw new IllegalArgumentException("rating values is out of range");
////        }
//        this.rating = new ArrayList<>(Arrays.asList(rating));
//    }

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

