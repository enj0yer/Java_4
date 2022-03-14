package ru.kulagin;

enum TColors implements TrafficColor{
    RED{
        public String get(){
            return "Red";
        }
        public TrafficColor next(){
            return GREEN;
        }
    },
    GREEN{
        public String get(){
            return "Green";
        }
        public TrafficColor next(){
            return RED;
        }
    };
}

enum OffColor implements TrafficColor{
    BLACK{
        public String get(){
            return "Black";
        }
        public TrafficColor next(){
            return BLACK;
        }
    }
}

interface TrafficColor{
    String get();
    TrafficColor next();
}

public class TrafficLight {
    private TrafficColor color = TColors.RED;

    public String next(){
        color = color.next();
        return color.toString();
    }

    public void on(){
        this.color = TColors.RED;
    }
    public void off(){
        this.color = OffColor.BLACK;
    }
}
