package com.example.dto;


import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoToEmployee {
    @NotBlank
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "First name start with capital letter only (e.g : Vishal)")
    private String firstName;
    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Last name start with capital letter only (e.g : Bhakare)")
    private String lastName;
    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Enter a valid email Id (e.g : vishal@gmail.com)")
    private String email;
    private LocalDate dateOfJoin;
    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^[789]\\d{9}$", message = "Phone number must start with 7, 8, or 9 and be exactly 10 digits long")
    private String phno;
    @Min(value = 18, message = "Age must be 18+")
    @Max(value = 50, message = "Age limit less than 50")
    private Integer age;
    @NotBlank
    @Pattern(regexp = "^(M|F)$", message = "Gender must be a single alphabetic character (e.g : M or F)")
    private String gender;
    private String department;
    private String notes;
    @DecimalMin(value = "5000.0", message = "Salary must be at least 5000.")
    @DecimalMax(value = "50000.0", message = "Salary must not exceed 50000.")
    private Double salary;
    private String profilePic;
    private List<DtoToAddress> addresses;
}
