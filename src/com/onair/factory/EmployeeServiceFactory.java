package com.onair.factory;

import com.onair.service.EmployeeService;
import com.onair.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
    private static EmployeeService employeeService;

    static {
        employeeService = new EmployeeServiceImpl();
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }
}
