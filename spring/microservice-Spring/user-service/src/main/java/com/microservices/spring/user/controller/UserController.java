package com.microservices.spring.user.controller;

import com.microservices.spring.user.model.User;
import com.microservices.spring.user.model.dto.LoginDto;
import com.microservices.spring.user.service.UserService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User register(@Validated @RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public User login(@Validated @RequestBody LoginDto dto) {
        return userService.login(dto.getUsername(), dto.getPassword());
    }

    @PostMapping("/logout/{username}")
    public void logout(@NotNull @PathVariable String username) {
        userService.logout(username);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/is-logged-in/{username}")
    public Boolean isLoggedIn(@NotNull @PathVariable  String username) {
        return userService.isLoggedIn(username);
    }

    @GetMapping("/get-name/{username}")
    public String getName(@NotNull @PathVariable String username) {
        return userService.getName(username);
    }
}
