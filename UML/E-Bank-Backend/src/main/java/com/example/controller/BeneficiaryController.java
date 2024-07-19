package com.example.controller;


import com.example.model.Beneficiary;
import com.example.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiary")
public class BeneficiaryController {

    @Autowired
    BeneficiaryService beneficiaryService;

    @PostMapping("/add-benef/{userId}")
    public Beneficiary addBeneficiary(@PathVariable Long userId , @RequestBody Beneficiary beneficiary){
        return beneficiaryService.addBeneficiary(userId, beneficiary);
    }

    @DeleteMapping
    public void deleteBeneficiary(@RequestParam Long id){
        beneficiaryService.deleteBeneficiary(id);
    }

    @GetMapping("/beneficiaries/1")
    public List<Beneficiary> getAllBeneficiary(@PathVariable Long userId){
       return beneficiaryService.findAllBeneficiary(userId);
    }
}
