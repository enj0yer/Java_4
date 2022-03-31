package ru.db;

import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employee_DAO {
    private static final String URL = "jdbc:h2:" + Paths.get("C:\\Users\\Kulag\\Test");
    private static final String USERNAME = "sa";
    private static final String DRIVER = "org.h2.Driver";


    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USERNAME, "");
        Statement statement = connection.createStatement();
        String query = "Select * from Employee";
        ResultSet rs = statement.executeQuery(query);



        List<Employee> employeeList = new ArrayList<>();

        while (rs.next()){
            employeeList.add(new Employee(
                    rs.getInt("id_employee"),
                    rs.getString("name"),
                    rs.getInt("id_department")
            ));
        }

        connection.close();

        return employeeList;
    }

    public List<Employee> getAllByName(String name) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USERNAME, "");
        PreparedStatement statement = connection.prepareStatement("Select * from Employee WHERE name = ?");
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();


        List<Employee> employeeList = new ArrayList<>();

        while (rs.next()){
            employeeList.add(new Employee(
                    rs.getInt("id_employee"),
                    rs.getString("name"),
                    rs.getInt("id_department")
            ));
        }

        connection.close();

        return employeeList;
    }

    public void save(Employee employee) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USERNAME, "");
        PreparedStatement statement = connection.prepareStatement("Select * from Employee WHERE id_employee = ?");
        statement.setInt(1, employee.getId_employee());
        ResultSet rs = statement.executeQuery();

        if (rs.next()){
            statement = connection.prepareStatement("Update Employee Set name = ?, id_department = ?  Where id_employee = ?");
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getId_department());
            statement.setInt(3, employee.getId_employee());
            statement.executeQuery();
            connection.close();
        }
        else {
            statement = connection.prepareStatement("Insert into Employee (name, id_department) values(?, ?)");
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getId_department());
            statement.executeQuery();
            connection.close();
        }

    }
}
