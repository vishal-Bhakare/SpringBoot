package com.example.dto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "First name start with capital letter only (e.g : Vishal)")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Last name start with capital letter only (e.g : Bhakare)")
    private String lastName;

    private LocalDate dob;
    private LocalDate registeredDate;
    private LocalDate updateDate;
    private String password;
   @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Enter a valid email Id (e.g : vishal@gmail.com)")
    private String emailId;

    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Role start with capital letter only (e.g : Developer)")
    private String role;

    public @Pattern(regexp = "^[A-Z][a-z]+$", message = "First name start with capital letter only (e.g : Vishal)") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Pattern(regexp = "^[A-Z][a-z]+$", message = "First name start with capital letter only (e.g : Vishal)") String firstName) {
        this.firstName = firstName;
    }

    public @Pattern(regexp = "^[A-Z][a-z]+$", message = "Last name start with capital letter only (e.g : Bhakare)") String getLastName() {
        return lastName;
    }

    public void setLastName(@Pattern(regexp = "^[A-Z][a-z]+$", message = "Last name start with capital letter only (e.g : Bhakare)") String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Enter a valid email Id (e.g : vishal@gmail.com)") String getEmailId() {
        return emailId;
    }

    public void setEmailId(@Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Enter a valid email Id (e.g : vishal@gmail.com)") String emailId) {
        this.emailId = emailId;
    }

    public @Pattern(regexp = "^[A-Z][a-z]+$", message = "Role start with capital letter only (e.g : Developer)") String getRole() {
        return role;
    }

    public void setRole(@Pattern(regexp = "^[A-Z][a-z]+$", message = "Role start with capital letter only (e.g : Developer)") String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", registeredDate=" + registeredDate +
                ", updateDate=" + updateDate +
                ", password='" + password + '\'' +
                ", emailId='" + emailId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
