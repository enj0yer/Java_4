package ru.kulagin.student;

public class RecordBook {
    long number;
    String studentName;
    Mark[] marks;

    public RecordBook(long number, String studentName, Mark[] marks){
        this.number = number;
        this.studentName = studentName;
        this.marks = marks.clone();
    }
    @Override
    public String toString(){
        String output = studentName + ", " + number + ":\n";
        for (Mark el : marks){
            output += "\t" + el.subject + ", " + el.surname + ", " + el.rating + "\n";
        }
        return output;
    }
}
