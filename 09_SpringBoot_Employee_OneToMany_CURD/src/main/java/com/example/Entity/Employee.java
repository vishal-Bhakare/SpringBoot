package com.example.Entity;

import com.example.dto.EmployeeToDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String firstName;
    private String lastName;
    private String email;
    private String phno;
    private Integer age;
    private String gender;
    private String department;
    private LocalDate dateOfJoin;
    private String notes;
    private Double salary;
    private String profilePic;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address> addresses;

}
