package ru.db;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Employee_DAO employee_dao = new Employee_DAO();
        Employee employee = new Employee(7, "Алексей", 3);
        employee_dao.save(employee);

    }
}
