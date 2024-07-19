package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User addUser(User user){
        return  userRepo.save(user);
    }


    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }


    public Optional<User> getUserById(Long id){
        return userRepo.findById(id);
    }

    public User loadUserBuyUserName (String userName){
        return userRepo.findByUserName(userName);
    }

    public List<User> userList(){
        return userRepo.findAll();
    }


}
