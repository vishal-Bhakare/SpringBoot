package com.example.serviceImpl;

import com.example.Entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public String addEmployee(Employee employee) {
        Employee save = repo.save(employee);
        return "Employee added successfully with ID: " + save.getEmpId();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {

        try {
            Optional<Employee> empId = repo.findById(id);

            if (empId.isPresent()) {
                Employee employee = empId.get();
                return employee;
            }
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String updateEmployee(Employee employee, Integer id) {

        try {
            Optional<Employee> empOptional = repo.findById(id);
            if (empOptional.isPresent()) {
                Employee existingEmp = empOptional.get();
                existingEmp.setFirstName(employee.getFirstName());
                existingEmp.setLastName(employee.getLastName());
                existingEmp.setEmail(employee.getEmail());
                existingEmp.setDepartment(employee.getDepartment());
                existingEmp.setSalary(employee.getSalary());
                repo.save(existingEmp);
                return "Employee updated successfully is Id : " +existingEmp.getEmpId();
            } else {
                return "Employee with ID " + id + " not found.";
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteEmployee(Integer id) {
        repo.deleteById(id);
        return "Employee Deleted Successfully..... :  "+id;
    }
}
