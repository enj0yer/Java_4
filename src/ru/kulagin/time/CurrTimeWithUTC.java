package ru.kulagin.time;

public class CurrTimeWithUTC extends CurrTime {
    int timezone;
    boolean timezoneHalf;

    public CurrTimeWithUTC(int time, int timezone, boolean timezoneHalf) {
        super(time);
        if (timezone >= -12 && timezone <= 14){
            this.timezone = timezone;
        }
        else throw new IllegalArgumentException("Wrong value of timezone");
        this.timezoneHalf = timezoneHalf;
    }
    public CurrTimeWithUTC(int hours, int minutes, int seconds, int timezone, boolean timezoneHalf){
        this(hours * 3600 + minutes * 60 + seconds, timezone, timezoneHalf);
    }

    public double getTimezone(){
        return timezone + ((timezoneHalf) ? 0.5 : 0);
    }

    @Override
    public String toString(){
        return (((hours < 10) ? "0" : "") + hours + ":" + ((minutes < 10) ? "0" : "") + minutes + ":" + ((seconds < 10) ? "0" : "") + seconds  + " " + ((timezone > 0) ? "+" + ((timezone < 10) ? "0" : "") + timezone : ((timezone < 10) ? "0" : "") + timezone) + ":" + (timezoneHalf ? 30 : 00) + " UTC");

    }

}
