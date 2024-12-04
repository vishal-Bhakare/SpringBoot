package com.example.controller;


import com.example.Entity.Employee;
import com.example.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody @Valid Employee employee) {
        String msg = service.addEmployee(employee);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(service.getAllEmployee(),HttpStatus.OK);
    }


    @GetMapping("/getEmp/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        return new ResponseEntity<>(service.getEmployee(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody @Valid Employee employee,@PathVariable Integer id){
        return new ResponseEntity<>(service.updateEmployee(employee,id),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
        return new ResponseEntity<>(service.deleteEmployee(id),HttpStatus.OK);
    }


}
