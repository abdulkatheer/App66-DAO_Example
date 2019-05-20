package com.onair.dao;

import com.onair.dto.Employee;
import com.onair.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    @Override
    public String add(Employee employee) {
        String status = "";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("SELECT * " +
                    "FROM employee WHERE id=?");
            statement.setString(1, employee.getId());
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                status = "exists";
            } else {
                statement = connection.prepareStatement("INSERT INTO employee" +
                        " VALUES(?,?,?,?)");
                statement.setString(1, employee.getId());
                statement.setString(2, employee.getName());
                statement.setString(3, employee.getDept());
                statement.setFloat(4, employee.getSalary());
                int rowCount = statement.executeUpdate();

                if(rowCount == 1) {
                    status = "success";
                } else {
                    status = "failed";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }

    @Override
    public Employee search(String id) {
        Employee employee = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("SELECT * FROM employee " +
                    "WHERE id=?");
            statement.setString(1, id);

            resultSet = statement.executeQuery();
            boolean b = resultSet.next();

            if (b) {
                employee = new Employee();
                employee.setId(resultSet.getString("id"));
                employee.setName(resultSet.getString("name"));
                employee.setDept(resultSet.getString("dept"));
                employee.setSalary(resultSet.getFloat("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public String delete(String id) {
        String status = "";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("DELETE FROM employee WHERE " +
                    "id=?");
            statement.setString(1, id);

            int rowCount = statement.executeUpdate();

            if (rowCount == 1) {
                status = "success";
            } else {
                status = "notexists";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            status = "failed";
        }
        return status;
    }

    @Override
    public String update(Employee employee) {
        String status = "";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement("UPDATE employee SET " +
                    "name=?, dept=?, salary=? WHERE id=?");

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDept());
            statement.setFloat(3, employee.getSalary());
            statement.setString(4, employee.getId());

            int rowCount = statement.executeUpdate();

            if (rowCount == 1) {
                status = "success";
            }
            else {
                status = "failed";
            }
        } catch (Exception e) {
            status = "failed";
            e.printStackTrace();
        }
        return status;
    }
}
