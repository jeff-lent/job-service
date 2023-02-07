package com.xloop.resourceloop.createJob.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.TechnicalSkill;
import com.xloop.resourceloop.createJob.Repository.TechnicalSkillRepository;

@Service
public class TechnicalSkillService {
    private final TechnicalSkillRepository technicalSkillRepository;

    public TechnicalSkillService(TechnicalSkillRepository technicalSkillRepository){
        this.technicalSkillRepository = technicalSkillRepository;
    }

    public TechnicalSkill addTechnicalSkill(TechnicalSkill technicalSkill){
        return technicalSkillRepository.save(technicalSkill);
    } 


    public void deleteTechnicalSkill(Long id){
        
        //jobRepository.deleteById(id);
       //List<Job> allJobs = jobRepository.findAll();
       //changing the value of isActive column.
        TechnicalSkill technicalSkill = technicalSkillRepository.findById(id).get();
        technicalSkill.setActive(false);
    //    jobRepository.save(pashaJob);
        technicalSkillRepository.save(technicalSkill);
        
    }

    public void reactiveTechnicalSkill(Long id){
        TechnicalSkill technicalSkill =  technicalSkillRepository.findById(id).get();
        technicalSkill.setActive(true);
        technicalSkillRepository.save(technicalSkill);
    }

    public List<TechnicalSkill> viewAllTechnicalSkills(){
        return technicalSkillRepository.findAll();
        
    }

}
