package com.microservices.spring.user.service;

import com.microservices.spring.user.exceptions.InvalidCredentialsException;
import com.microservices.spring.user.exceptions.NoSuchUserException;
import com.microservices.spring.user.model.User;
import com.microservices.spring.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private List<User> loggedIn;

    @PostConstruct
    public void setup() {
        loggedIn = new ArrayList<>();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findById(username).orElseThrow(InvalidCredentialsException::new);
        if(user.getPassword().equals(password)) {
            loggedIn.add(user);
            return user;
        }
        throw new InvalidCredentialsException();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Boolean isLoggedIn(String username) {
        return loggedIn.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    public void logout(String username) {
        loggedIn.removeIf(u -> u.getUsername().equals(username));
    }

    public String getName(String username) {
        User user = userRepository.findById(username).orElseThrow(NoSuchUserException::new);
        return user.getFirstName();
    }


}
