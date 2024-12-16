package com.example.service;

import com.example.dto.DtoToEmployee;
import com.example.dto.EmployeeToDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public String addEmployee(DtoToEmployee dtEmp);
    public EmployeeToDto getEmployeeById(Integer id);
    public List<EmployeeToDto> getAllEmployee();
    public String updateEmployee(DtoToEmployee dtEmp, Integer id);
   public String deleteEmployeeById(Integer id);
   public String deleteEmployeeAddressByAddressType(Integer id, String addressType);
    public String patchEmployee(Map<String, Object> updates, Integer id);
}
