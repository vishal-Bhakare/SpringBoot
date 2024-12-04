package com.example.Entity;
import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @NotBlank(message ="First Name Is Mandatory")
    @Size(min = 1, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message ="Last Name Is Mandatory")
    @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Department is mandatory")
    @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters")
    private String department;

    @NotNull(message = "Salary is mandatory")
    @Positive(message = "Salary must be a positive number")
    private Double salary;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public @NotBlank(message = "First Name Is Mandatory") @Size(min = 1, max = 50, message = "First name must be between 2 and 50 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First Name Is Mandatory") @Size(min = 1, max = 50, message = "First name must be between 2 and 50 characters") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "First Name Is Mandatory") @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "First Name Is Mandatory") @Size(min = 1, max = 50, message = "Last name must be between 2 and 50 characters") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Department is mandatory") @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters") String getDepartment() {
        return department;
    }

    public void setDepartment(@NotBlank(message = "Department is mandatory") @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters") String department) {
        this.department = department;
    }

    public @NotNull(message = "Salary is mandatory") @Positive(message = "Salary must be a positive number") Double getSalary() {
        return salary;
    }

    public void setSalary(@NotNull(message = "Salary is mandatory") @Positive(message = "Salary must be a positive number") Double salary) {
        this.salary = salary;
    }
}
