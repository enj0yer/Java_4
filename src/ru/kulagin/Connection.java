package ru.kulagin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public interface Connection {

    Map<String, Supplier<Connection>> MAP = new HashMap();
    static Connection of(String name){
        return MAP.get(name.split(".")[1]).get();
    }
}
