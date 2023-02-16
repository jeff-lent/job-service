package com.xloop.resourceloop.createJob.Service.DropDownService;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.DropDownModel.SoftSkill;
import com.xloop.resourceloop.createJob.Repository.SoftSkillRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;

@Service
public class SoftSkillService extends GenericDropDown<SoftSkill, SoftSkillRepository> {
    

    // private SoftSkillRepository softSkillRepository;

    public SoftSkillService(SoftSkillRepository softSkillRepository){
        // this.softSkillRepository = softSkillRepository;
        super(softSkillRepository);
    }

}
