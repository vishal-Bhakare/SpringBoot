package com.example.serviceImpl;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public String addUser(UserDto userDto) {
        String str = " ";
        if (userDto == null) {
            str = "Please Enter All The Fileds....";
        }
        try {
            User user = convertToEntity(userDto);
            repo.save(user);
            str = "User Registration SuccessFully.....";
        } catch (RuntimeException e) {
            str = "Exceptions Occured...";
            throw new RuntimeException(e);
        }
        return str;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            User user1 = user.get();
            return convertToDto(user1);
        } else {
            throw new RuntimeException("User not found for ID: " + id);
        }
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = repo.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public String updateUser(UserDto dto, Long id) {
        String str = "";
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            User us = user.get();
            us.setFirstName(dto.getFirstName());
            us.setLastName(dto.getLastName());
            us.setDob(LocalDate.now());
            us.setRegisteredDate(LocalDate.now());
            us.setUpdateDate(LocalDate.now());
            us.setPassword(dto.getPassword());
            us.setEmailId(dto.getEmailId());
            us.setRole(dto.getRole());
            repo.save(us);
            str = "User Update SuccessFully... ID : " + id;
        } else {
            str = "User Not Fount At ID : " + id;
        }
        return str;
    }

    @Override
    public String deleteUserById(Long id) {
        String str;
        Optional<User> employee = repo.findById(id);
        if (employee.isPresent()) {
            repo.deleteById(id);
            str = "User Deleted SuccessFully..... ID : " + id;
        } else {
            str = "User Not Found..... ID : " + id;
        }
        return str;
    }

    @Override
    public String login(String emailId, String password) {
        User user = repo.findByEmailId(emailId)
                .orElseThrow(() -> new RuntimeException("Invalid email or password: " + emailId));
        if (user.getPassword().equals(password)) {
            return "Login successfully......";
        }
        return "Invalid email or password";
    }


    @Override
    public String reSetPassword(String emailId, String currentPassword, UserDto dto) {

        User user = repo.findByEmailId(emailId)
                .orElseThrow(() -> new RuntimeException("Invalid email: " + emailId));

        if (!user.getPassword().equals(currentPassword)) {
            return "Current password is incorrect.";
        }
        user.setPassword(dto.getPassword());
        repo.save(user);
        return "Password updated successfully.";
    }

    @Override
    public String forgetPassword(String emailId) {

        User user = repo.findByEmailId(emailId)
                .orElseThrow(() -> new RuntimeException("Email not found: " + emailId));
        String tempPassword = generateTemporaryPassword();
        user.setPassword(tempPassword);
        repo.save(user);
        return tempPassword;
    }

    private String generateTemporaryPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }


    private User convertToEntity(UserDto userDto) {
        User us = new User();
        us.setFirstName(userDto.getFirstName());
        us.setLastName(userDto.getLastName());
        us.setDob(LocalDate.now());
        us.setRegisteredDate(LocalDate.now());
        us.setUpdateDate(LocalDate.now());
        us.setPassword(userDto.getPassword());
        us.setEmailId(userDto.getEmailId());
        us.setRole(userDto.getRole());
        return us;
    }

    private UserDto convertToDto(User us) {
        UserDto dto = new UserDto();
        dto.setFirstName(us.getFirstName());
        dto.setLastName(us.getLastName());
        dto.setDob(LocalDate.now());
        dto.setRegisteredDate(LocalDate.now());
        dto.setUpdateDate(LocalDate.now());
        dto.setPassword(us.getPassword());
        dto.setEmailId(us.getEmailId());
        dto.setRole(us.getRole());
        return dto;
    }

}
