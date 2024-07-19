package com.example.controller;


import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userServices;

    @PostMapping("/save")
    public User addUser(@RequestBody User user) {
        return userServices.addUser(user);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServices.deleteUser(id);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userServices.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> userList(){
        return userServices.userList();
    }


//    @PostMapping("/login")
//    public String login(@RequestBody User user){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword() )
//        );
//
//        return JwtAuthenticationFilter.genarateToken(user.getUserName());
//    }





}
