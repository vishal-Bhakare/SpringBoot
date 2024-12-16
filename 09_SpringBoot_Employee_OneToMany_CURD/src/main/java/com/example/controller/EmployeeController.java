package com.example.controller;

import com.example.dto.DtoToEmployee;
import com.example.dto.EmployeeToDto;
import com.example.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody DtoToEmployee dtEmp) {
        return new ResponseEntity<>(service.addEmployee(dtEmp), HttpStatus.CREATED);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
        try {
            EmployeeToDto emp = service.getEmployeeById(id);
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeToDto>> getAllEmployee() {
        return new ResponseEntity<>(service.getAllEmployee(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody @Valid DtoToEmployee dtEmp, @PathVariable Integer id) {
        return new ResponseEntity<>(service.updateEmployee(dtEmp, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.deleteEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}/{addressType}")
    public ResponseEntity<String> deleteEmployeeAddressByAddressType(@PathVariable Integer id, @PathVariable String addressType) {
        return new ResponseEntity<>(service.deleteEmployeeAddressByAddressType(id, addressType), HttpStatus.OK);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<String> patchEmployee( @RequestBody @Valid  Map<String, Object> updates,@PathVariable Integer id) {
        try {
            String response = service.patchEmployee(updates, id);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating.");
        }
    }

}
