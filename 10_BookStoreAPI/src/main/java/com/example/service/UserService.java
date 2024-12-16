package com.example.service;

import com.example.dto.UserDto;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    public String addUser(UserDto userDto);

    public UserDto getUserById(Long id);

    public List<UserDto> getAllUser();

    public String updateUser(UserDto dto, Long id);

    public String deleteUserById(Long id);

    public boolean login(String emailId, String password);

    public String reSetPassword(String emailId, String password, UserDto dto);

    public String forgetPassword(String emailId);
}
