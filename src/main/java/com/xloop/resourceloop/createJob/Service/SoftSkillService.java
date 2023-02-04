package com.xloop.resourceloop.createJob.Service;

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

}
