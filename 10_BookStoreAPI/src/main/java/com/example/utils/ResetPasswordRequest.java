package com.example.utils;

import com.example.dto.UserDto;

public class ResetPasswordRequest {
    private String emailId;
    private String currentPassword;
    private UserDto userDto; // Nested object

    // Getters and setters
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}

