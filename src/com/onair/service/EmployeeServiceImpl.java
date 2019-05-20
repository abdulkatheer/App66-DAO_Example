package com.onair.service;

import com.onair.dao.EmployeeDao;
import com.onair.dto.Employee;
import com.onair.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao = null;
    @Override
    public String addEmployee(Employee employee) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.add(employee);
    }

    @Override
    public Employee searchEmployee(String id) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.search(id);
    }

    @Override
    public String deleteEmployee(String id) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return employeeDao.delete(id);
    }

    @Override
    public String updateEmployee(Employee employee) {
        employeeDao = EmployeeDaoFactory.getEmployeeDao();
        return  employeeDao.update(employee);
    }
}
