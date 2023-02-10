package com.xloop.resourceloop.createJob.Service.DropDownService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.BenefitsPerks;
import com.xloop.resourceloop.createJob.Repository.BenefitsPerksRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;

@Service
public class BenefitsPerksService extends GenericDropDown<BenefitsPerks, BenefitsPerksRepository>  {

    // private final BenefitsPerksRepository benefitsPerksRepository;

    public BenefitsPerksService(BenefitsPerksRepository benefitsPerksRepository){
        // this.benefitsPerksRepository=benefitsPerksRepository;
        super(benefitsPerksRepository);
    }


    // public BenefitsPerks add(BenefitsPerks benefitsPerks){
    //     return benefitsPerksRepository.save(benefitsPerks);
    // } 

    // public BenefitsPerks update(BenefitsPerks benefitsPerks){
    //     return benefitsPerksRepository.save(benefitsPerks);
    // } 

    // public void deactivate(Long id){
    //     BenefitsPerks benefitsPerks = benefitsPerksRepository.findById(id).get();
    //     benefitsPerks.setActive(false);
    //     benefitsPerksRepository.save(benefitsPerks);
        
    // }


    // public void reactive(Long id){
    //     BenefitsPerks benefitsPerks =  benefitsPerksRepository.findById(id).get();
    //     benefitsPerks.setActive(true);
    //     benefitsPerksRepository.save(benefitsPerks);
    // }


    // public List<BenefitsPerks> viewAll(){
    //     return benefitsPerksRepository.findAll();
        
    // }




}
