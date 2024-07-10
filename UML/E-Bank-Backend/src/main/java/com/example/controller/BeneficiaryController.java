package com.example.controller;


import com.example.model.Beneficiary;
import com.example.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BeneficiaryController {

    @Autowired
    BeneficiaryService beneficiaryService;

    @PostMapping
    public Beneficiary addBeneficiary(@RequestBody Beneficiary beneficiary){
        return beneficiaryService.addBeneficiary(beneficiary);
    }

    @DeleteMapping
    public void deleteBeneficiary(@RequestParam Long id){
        beneficiaryService.deleteBeneficiary(id);
    }

    @GetMapping
    public List<Beneficiary> getAllBeneficiary(@PathVariable Long userId){
       return beneficiaryService.getAllBeneficiary(userId);
    }
}
