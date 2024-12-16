package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import com.example.utils.ResetPasswordRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return new ResponseEntity<>(service.addUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            UserDto us = service.getUserById(id);
            return new ResponseEntity<>(us, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@RequestBody @Valid UserDto dto, @PathVariable Long id) {
        return new ResponseEntity<>(service.updateUser(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteUserById(id), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Map<String, String> loginDetails) {
        String emailId = loginDetails.get("emailId");
        String password = loginDetails.get("password");
        boolean loginSuccess = service.login(emailId, password);
        return new ResponseEntity<>(loginSuccess, HttpStatus.OK);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> reSetPassword(@RequestBody ResetPasswordRequest pass) {
        String emailId = pass.getEmailId();
        String password = pass.getCurrentPassword();
        UserDto dto = pass.getUserDto();
        String reset = service.reSetPassword(emailId, password, dto);
        return new ResponseEntity<>(reset, HttpStatus.OK);
    }

    @PostMapping("/forget")
    public ResponseEntity<String> forgetPassword(@RequestBody Map<String, String> request) {
        String emailId = request.get("emailId");

        if (emailId == null || emailId.isEmpty()) {
            throw new IllegalArgumentException("Email ID is required.");
        }
        String tempPassword = service.forgetPassword(emailId);
        return new ResponseEntity<>("Temporary password: " + tempPassword, HttpStatus.OK);
    }
}
