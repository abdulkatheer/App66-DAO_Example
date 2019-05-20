package com.onair.service;

import com.onair.dto.Employee;

public interface EmployeeService {
    String addEmployee(Employee employee);
    Employee searchEmployee(String id);
    String deleteEmployee(String id);
    String updateEmployee(Employee employee);
}
