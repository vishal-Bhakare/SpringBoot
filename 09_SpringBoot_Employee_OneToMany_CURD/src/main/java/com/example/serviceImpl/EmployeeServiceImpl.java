package com.example.serviceImpl;
import com.example.Entity.Address;
import com.example.Entity.Employee;
import com.example.dto.AddressToDto;
import com.example.dto.DtoToEmployee;
import com.example.dto.EmployeeToDto;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Override
    public String addEmployee(DtoToEmployee dtEmp) {

        String str = "";
        if (dtEmp == null) {
            str = "Please Enter All The Fileds....";
        }
        try {
            Employee emp = convertToEntity(dtEmp);
            repo.save(emp);
            str = "Employee Saved SuccessFully............";
        } catch (RuntimeException e) {
            str = "Employee Not Saved Error occured............";
            throw new RuntimeException(e);
        }
        return str;
    }

    @Override
    public EmployeeToDto getEmployeeById(Integer id) {
        Optional<Employee> emp = repo.findById(id);
        if (emp.isPresent()) {
            Employee employee = emp.get();
            return convertToDTO(employee);
        } else {
            throw new RuntimeException("Employee not found for ID: " + id);
        }
    }

    @Override
    public List<EmployeeToDto> getAllEmployee() {
        List<Employee> employess = repo.findAll();
        return employess.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

  /*  @Override
    public String updateEmployee(DtoToEmployee dtoToEmployee, Integer id) {
        String str;
        Optional<Employee> employee = repo.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            emp.setFirstName(dtoToEmployee.getFirstName());
            emp.setLastName(dtoToEmployee.getLastName());
            emp.setEmail(dtoToEmployee.getEmail());
            emp.setPhno(dtoToEmployee.getPhno());
            emp.setAge(dtoToEmployee.getAge());
            emp.setGender(dtoToEmployee.getGender());
            emp.setDepartment(dtoToEmployee.getDepartment());
            emp.setNotes(dtoToEmployee.getNotes());
            emp.setSalary(dtoToEmployee.getSalary());
            emp.setProfilePic(dtoToEmployee.getProfilePic());
            // Convert and set addresses
            List<Address> addresses = dtoToEmployee.getAddresses().stream().map(dtoAddress -> {
                Address address = new Address();
                address.setAddressType(dtoAddress.getAddressType());
                address.setHouseNo(dtoAddress.getHouseNo());
                address.setStreetName(dtoAddress.getStreetName());
                address.setCity(dtoAddress.getCity());
                address.setState(dtoAddress.getState());
                address.setPinCode(dtoAddress.getPinCode());
                return address;
            }).collect(Collectors.toList());
            emp.setAddresses(addresses);
            repo.save(emp);
            str = "Employee updated successfully";
        } else {
            str = "Employee not found with ID: " + id;
        }
        return str;
    }*/


    @Override
    public String updateEmployee(DtoToEmployee dtoToEmployee, Integer id) {
        String str;
        Optional<Employee> employee = repo.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            emp.setFirstName(dtoToEmployee.getFirstName());
            emp.setLastName(dtoToEmployee.getLastName());
            emp.setEmail(dtoToEmployee.getEmail());
            emp.setPhno(dtoToEmployee.getPhno());
            emp.setAge(dtoToEmployee.getAge());
            emp.setGender(dtoToEmployee.getGender());
            emp.setDepartment(dtoToEmployee.getDepartment());
            emp.setNotes(dtoToEmployee.getNotes());
            emp.setSalary(dtoToEmployee.getSalary());
            emp.setProfilePic(dtoToEmployee.getProfilePic());
            // Update addresses
            List<Address> existingAddresses = emp.getAddresses();
            existingAddresses.clear(); // Clear the current addresses
            // Convert and add new addresses
            List<Address> newAddresses = dtoToEmployee.getAddresses().stream().map(dtoAddress -> {
                Address address = new Address();
                address.setAddressType(dtoAddress.getAddressType());
                address.setHouseNo(dtoAddress.getHouseNo());
                address.setStreetName(dtoAddress.getStreetName());
                address.setCity(dtoAddress.getCity());
                address.setState(dtoAddress.getState());
                address.setPinCode(dtoAddress.getPinCode());
                return address;
            }).collect(Collectors.toList());
            existingAddresses.addAll(newAddresses); // Add all new addresses
            repo.save(emp); // Save the updated employee
            str = "Employee updated successfully";
        } else {
            str = "Employee not found with ID: " + id;
        }
        return str;
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        String str;
        Optional<Employee> employee = repo.findById(id);
        if (employee.isPresent()) {
            repo.deleteById(id);
            str = "Employee Deleted SuccessFully..... ID : " + id;
        } else {
            str = "Employee Not Found..... ID : " + id;
        }
        return str;
    }


    private Employee convertToEntity(DtoToEmployee dtEmp) {
        Employee emp = new Employee();
        emp.setFirstName(dtEmp.getFirstName());
        emp.setLastName(dtEmp.getLastName());
        emp.setEmail(dtEmp.getEmail());
        emp.setPhno(dtEmp.getPhno());
        emp.setAge(dtEmp.getAge());
        emp.setGender(dtEmp.getGender());
        emp.setDepartment(dtEmp.getDepartment());
        emp.setDateOfJoin(LocalDate.now());
        emp.setNotes(dtEmp.getNotes());
        emp.setSalary(dtEmp.getSalary());
        emp.setProfilePic(dtEmp.getProfilePic());
        // Convert and set addresses
        List<Address> list = dtEmp.getAddresses().stream().map(dtoAddress -> {
            Address address = new Address();
            address.setAddressType(dtoAddress.getAddressType());
            address.setHouseNo(dtoAddress.getHouseNo());
            address.setStreetName(dtoAddress.getStreetName());
            address.setCity(dtoAddress.getCity());
            address.setState(dtoAddress.getState());
            address.setPinCode(dtoAddress.getPinCode());
            return address;
        }).collect(Collectors.toList());
        emp.setAddresses(list);
        return emp;
    }

    private EmployeeToDto convertToDTO(Employee employee) {
        EmployeeToDto dto = new EmployeeToDto();
        dto.setEmpId(employee.getEmpId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setPhno(employee.getPhno());
        dto.setAge(employee.getAge());
        dto.setGender(employee.getGender());
        dto.setDepartment(employee.getDepartment());
        dto.setDateOfJoin(employee.getDateOfJoin());
        dto.setNotes(employee.getNotes());
        dto.setSalary(employee.getSalary());
        dto.setProfilePic(employee.getProfilePic());

        // Convert addresses to DTOs
        List<AddressToDto> addressDtos = employee.getAddresses().stream().map(address -> {
            AddressToDto addressToDto = new AddressToDto();
            addressToDto.setAddressType(address.getAddressType());
            addressToDto.setHouseNo(address.getHouseNo());
            addressToDto.setStreetName(address.getStreetName());
            addressToDto.setCity(address.getCity());
            addressToDto.setState(address.getState());
            addressToDto.setPinCode(address.getPinCode());
            return addressToDto;
        }).collect(Collectors.toList());
        dto.setAddress(addressDtos);
        return dto;
    }


    @Override
    public String deleteEmployeeAddressByAddressType(Integer id, String addressType) {
        String msg;
        Optional<Employee> employee = repo.findById(id);
//        Optional<EmployeeToDto> employeeById = getEmployeeById(id);
        if (employee.isPresent()) {
            Employee employees = employee.get();

            Optional<Address> addressToDelete = employees.getAddresses()
                    .stream()
                    .filter(address -> address.getAddressType().equalsIgnoreCase(addressType))
                    .findFirst();

            if (addressToDelete.isPresent()) {

                employees.getAddresses().remove(addressToDelete.get());
//                Employee employee = convertToEntity(employeeToDto);
                repo.save(employees);
                msg = "Address deleted successfully... ID : " + id;
            } else {
                msg = "Address not found with Address-Type: " + addressType;
            }
        } else {
            msg = "Employee not found with ID: " + id;
        }
        return msg;
    }

   /* @Override
    public String patchEmployee(Map<String, Object> updates, Integer id) {
        String str;
        Optional<Employee> byId = repo.findById(id);
        if (byId.isPresent()) {
            Employee employee = byId.get();
            updates.forEach((field, value) -> {
                Field declaredField = ReflectionUtils.findField(Employee.class, field);
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    ReflectionUtils.setField(declaredField, employee, value);
                }
            });
            repo.save(employee);
            str = "Employee updated successfully.";
        } else {
            str = "Employee not found with ID: " + id;
        }
        return str;
    }*/


    public String patchEmployee(Map<String, Object> updates, Integer id) {
        Optional<Employee> optionalEmployee = repo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee emp = optionalEmployee.get();
            updates.forEach((field, value) -> {
                try {
                    if ("addresses".equals(field) && value instanceof List) {
                        // Handle addresses separately
                        List<Map<String, Object>> addressList = (List<Map<String, Object>>) value;
                        List<Address> newAddresses = addressList.stream().map(map -> {
                            Address address = new Address();
                            address.setAddressType((String) map.get("addressType"));
                            address.setHouseNo((String) map.get("houseNo"));
                            address.setStreetName((String) map.get("streetName"));
                            address.setCity((String) map.get("city"));
                            address.setState((String) map.get("state"));
                            address.setPinCode((String) map.get("pinCode"));
                            return address;
                        }).collect(Collectors.toList());
                        if (emp.getAddresses() == null) {
                            emp.setAddresses(new ArrayList<>());
                        }
                        emp.getAddresses().clear();
                        emp.getAddresses().addAll(newAddresses);
                    } else {
                        // Handle other fields dynamically
                        Field entityField = Employee.class.getDeclaredField(field);
                        entityField.setAccessible(true);

                        // Check for primitive types and cast accordingly
                        if (entityField.getType().isPrimitive()) {
                            if (entityField.getType().equals(int.class)) {
                                entityField.set(emp, ((Number) value).intValue());
                            } else if (entityField.getType().equals(double.class)) {
                                entityField.set(emp, ((Number) value).doubleValue());
                            } else if (entityField.getType().equals(boolean.class)) {
                                entityField.set(emp, Boolean.valueOf(value.toString()));
                            } else {
                                throw new IllegalArgumentException("Unsupported primitive type: " + entityField.getType());
                            }
                        } else {
                            entityField.set(emp, value);
                        }
                    }
                } catch (NoSuchFieldException e) {
                    throw new IllegalArgumentException("Invalid field: " + field, e);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException("Unable to access field: " + field, e);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException("Invalid data type for field: " + field, e);
                }
            });
            repo.save(emp);
            return "Employee updated successfully";
        } else {
            return "Employee not found with ID: " + id;
        }
    }
}
