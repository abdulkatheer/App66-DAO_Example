package com.onair.factory;

import com.onair.dao.EmployeeDao;
import com.onair.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
    private static EmployeeDao employeeDao;

    static {
        employeeDao = new EmployeeDaoImpl();
    }

    public static EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
}
