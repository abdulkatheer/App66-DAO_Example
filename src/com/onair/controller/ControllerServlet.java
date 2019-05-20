package com.onair.controller;

import com.onair.dto.Employee;
import com.onair.factory.EmployeeServiceFactory;
import com.onair.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1l;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPath = req.getRequestURI();
        EmployeeService employeeService =
                EmployeeServiceFactory.getEmployeeService();

        if (requestPath.endsWith("add.do")) {
            Employee employee = new Employee();
            employee.setName(req.getParameter("name"));
            employee.setId(req.getParameter("id"));
            employee.setDept(req.getParameter("dept"));
            employee.setSalary(Float.parseFloat(req.getParameter("salary")));

            String status = employeeService.addEmployee(employee);

            RequestDispatcher requestDispatcher = null;

            if (status.equals("success")) {
                req.setAttribute("status", "Employee Inserted Successfully!");
                requestDispatcher = req.getRequestDispatcher("/response" +
                        "/status.jsp");
                requestDispatcher.forward(req, resp);

            } else if (status.equals("failed")) {
                req.setAttribute("status", "Employee Insertion failed!");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);

            } else if (status.equals("exists")) {
                req.setAttribute("status", "Employee with ID " + employee.getId() + " already exists!");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);

            }
        }

        else if (requestPath.endsWith("search.do")) {
            Employee employee = employeeService.searchEmployee(req.getParameter("id"));

            RequestDispatcher requestDispatcher = null;

            if(employee == null) {
                req.setAttribute("status", "Employee with ID " + req.getParameter("id") + " not exists!");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);

            } else {
                req.setAttribute("employee", employee);
                requestDispatcher = req.getRequestDispatcher("/response/display.jsp");
                requestDispatcher.forward(req, resp);

            }

        }

        else if (requestPath.endsWith("delete.do")) {
            String status = employeeService.deleteEmployee(req.getParameter("id"));

            RequestDispatcher requestDispatcher = null;

            if (status.equals("success")) {
                req.setAttribute("status", "Employee deleted successfully!");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);

            } else if (status.equals("failed")) {
                req.setAttribute("status", "Employee delete failed!");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);
            } else if (status.equals("notexists")) {
                req.setAttribute("status", "Employee with ID " + req.getParameter("id") + " not exists!");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);
            }
        }

        else if (requestPath.endsWith("updateStep1.do")) {
            Employee employee = employeeService.searchEmployee(req.getParameter("id"));

            RequestDispatcher requestDispatcher = null;

            if (employee == null) {
                req.setAttribute("status","Employee with ID " + req.getParameter("id") + " not exists");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);
            }

            else {
                req.setAttribute("employee", employee);
                requestDispatcher = req.getRequestDispatcher("/form/updateFormStep2.jsp");
                requestDispatcher.forward(req, resp);
            }
        }

        else if (requestPath.endsWith("updateStep2.do")) {
            Employee employee = new Employee();
            employee.setId(req.getParameter("id"));
            employee.setName(req.getParameter("name"));
            employee.setDept(req.getParameter("dept"));
            employee.setSalary(Float.parseFloat(req.getParameter("salary")));

            String status = employeeService.updateEmployee(employee);

            RequestDispatcher requestDispatcher = null;

            if (status.equals("success")) {
                req.setAttribute("status", "Employee details updated successfully!");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);
            }

            else if (status.equals("failed")) {
                req.setAttribute("status","Employee update failed!");
                requestDispatcher = req.getRequestDispatcher("/response/status.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
    }
}
