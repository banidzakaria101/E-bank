package com.example.controller;


import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userServices;

    @PostMapping
    public User addUser(User user){
        return userServices.addUser(user);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id){
        userServices.deleteUser(id);
    }
}
