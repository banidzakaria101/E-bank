package com.example.service;

import com.example.model.Beneficiary;
import com.example.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class BeneficiaryService {

    @Autowired
    BeneficiaryRepository beneficiaryRepo;

    public Beneficiary addBeneficiary(Beneficiary beneficiary){
        beneficiaryRepo.save(beneficiary);
        return beneficiary;
    }

    public  void deleteBeneficiary(Long id){
        beneficiaryRepo.deleteById(id);
    }

      public List<Beneficiary> getAllBeneficiary (@PathVariable Long userId){
        return beneficiaryRepo.getAllBeneficiary(userId);
    }

}
