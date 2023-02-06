package com.xloop.resourceloop.createJob.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.SoftSkill;
import com.xloop.resourceloop.createJob.Repository.SoftSkillRepository;

@Service
public class SoftSkillService {
    
    private final SoftSkillRepository softSkillRepository;
    
    public SoftSkillService(SoftSkillRepository softSkillRepository ) {
        this.softSkillRepository= softSkillRepository;
    }

    public SoftSkill addSoftSkill(SoftSkill softSkill){
        return softSkillRepository.save(softSkill);
    } 



    // public void deleteSoftSkill(Long id){
    // softSkillRepository.deleteById(id);
        

    // }

    public void deleteSoftSkill(Long id){
        
        //jobRepository.deleteById(id);
       //List<Job> allJobs = jobRepository.findAll();
       //changing the value of isActive column.
        SoftSkill softSkill =  softSkillRepository.findById(id).get();
        softSkill.setActive(false);
    //    jobRepository.save(pashaJob);
        softSkillRepository.save(softSkill);
        
    }

    public void reactiveSoftSkill(Long id){
        SoftSkill softSkill =  softSkillRepository.findById(id).get();
        softSkill.setActive(true);
        softSkillRepository.save(softSkill);
    }

    public List<SoftSkill> viewAllSoftSkills(){
        return softSkillRepository.findAll();
        
    }

    


}
