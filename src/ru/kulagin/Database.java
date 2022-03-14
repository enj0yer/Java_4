package ru.kulagin;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<String> data = new ArrayList<>();
    private final DBConnection[] connections = new DBConnection[5];

    {
        for (int i = 0; i < 10; i++){
            data.add("" + i);
        }

    }
}
