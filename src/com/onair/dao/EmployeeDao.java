package com.onair.dao;

import com.onair.dto.Employee;

public interface EmployeeDao {
    String add(Employee employee);
    Employee search(String id);
    String delete(String id);
    String update(Employee employee);
}
