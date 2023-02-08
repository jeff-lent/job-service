package com.xloop.resourceloop.createJob.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.BenefitsPerks;
import com.xloop.resourceloop.createJob.Repository.BenefitsPerksRepository;

@Service
public class BenefitsPerksService {

    private final BenefitsPerksRepository benefitsPerksRepository;

    public BenefitsPerksService(BenefitsPerksRepository benefitsPerksRepository){
        this.benefitsPerksRepository=benefitsPerksRepository;
    }


    public BenefitsPerks addBenefitsPerks(BenefitsPerks benefitsPerks){
        return benefitsPerksRepository.save(benefitsPerks);
    } 



    public void deleteBenefitsPerks(Long id){
        
        //jobRepository.deleteById(id);
       //List<Job> allJobs = jobRepository.findAll();
       //changing the value of isActive column.
        BenefitsPerks benefitsPerks = benefitsPerksRepository.findById(id).get();
        benefitsPerks.setActive(false);
    //    jobRepository.save(pashaJob);
        benefitsPerksRepository.save(benefitsPerks);
        
    }


    public void reactiveBenefitsPerks(Long id){
        BenefitsPerks benefitsPerks =  benefitsPerksRepository.findById(id).get();
        benefitsPerks.setActive(true);
        benefitsPerksRepository.save(benefitsPerks);
    }


    public List<BenefitsPerks> viewAllBenefitsPerks(){
        return benefitsPerksRepository.findAll();
        
    }




}
