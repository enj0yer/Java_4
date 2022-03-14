package ru.kulagin.time;

public class CurrTime {

    protected int hours = 0;
    protected int minutes = 0;
    protected int seconds = 0;

    public CurrTime(int time){
        if (time < 0) throw new IllegalArgumentException("time is negative");
        hours = time / 3600;
        seconds = time % (hours * 3600);
        minutes = seconds / 60;
        if (minutes != 0){
            seconds %= minutes * 60;
        }

        hours %= 24;
    }
    public CurrTime(int hours, int minutes, int seconds){
        this(hours * 3600 + minutes * 60 + seconds);
    }

    public int getHours(){
        return hours;
    }
    public int getMinutes(){
        return minutes;
    }
    public int getSeconds(){
        return seconds;
    }

    @Override
    public String toString(){
        return ((hours < 10) ? "0" : "") + hours + ":" + ((minutes < 10) ? "0" : "") + minutes + ":" + ((seconds < 10) ? "0" : "") + seconds;
    }
}
