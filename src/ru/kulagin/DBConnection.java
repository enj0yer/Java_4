package ru.kulagin;


import java.util.Optional;

public class DBConnection implements AutoCloseable{
    private boolean isUsing = false;

    private static int count = 5;

    private DBConnection(){

    }

    public void close(){
        if (this.isUsing){
            this.isUsing = false;
            count++;
        }
    }

    public static Optional<DBConnection> get(){
        if (count > 0){
            count--;
            return Optional.of(new DBConnection());
        }
        else return Optional.empty();
    }
    public String next(){
        if (isUsing){
            return "hw";
        }
        return null;
    }

}
class XMLConnection {

}
class JSONConnection {
}
