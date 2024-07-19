package com.example.service;

import com.example.model.Beneficiary;
import com.example.model.User;
import com.example.repository.BeneficiaryRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class BeneficiaryService {

    @Autowired
    BeneficiaryRepository beneficiaryRepo;

    @Autowired
    UserRepository userRepo;

    public Beneficiary addBeneficiary(Long userId, Beneficiary beneficiary) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        beneficiary.setUser(user);
        return beneficiaryRepo.save(beneficiary);
    }

    public  void deleteBeneficiary(Long id){
        beneficiaryRepo.deleteById(id);
    }

      public List<Beneficiary> findAllBeneficiary (@PathVariable Long userId){
        return beneficiaryRepo.findAllById(userId);
    }

}
