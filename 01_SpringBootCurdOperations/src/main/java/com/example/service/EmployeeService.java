package com.example.service;

import com.example.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    public String addEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployee(Integer id);
    public String updateEmployee(Employee employee,Integer id);
    public  String deleteEmployee(Integer id);

}
