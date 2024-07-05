package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User addUser(User user){
        return  userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
