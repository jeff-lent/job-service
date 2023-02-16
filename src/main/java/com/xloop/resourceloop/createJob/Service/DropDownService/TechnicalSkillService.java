package com.xloop.resourceloop.createJob.Service.DropDownService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.DropDownModel.TechnicalSkill;
import com.xloop.resourceloop.createJob.Repository.TechnicalSkillRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;
import com.xloop.resourceloop.createJob.ServiceInterface.InterfaceForDropDowns;

@Service
public class TechnicalSkillService extends GenericDropDown<TechnicalSkill, TechnicalSkillRepository> {

    // private final TechnicalSkillRepository technicalSkillRepository;

    public TechnicalSkillService(TechnicalSkillRepository technicalSkillRepository){
        // this.technicalSkillRepository = technicalSkillRepository;
        super(technicalSkillRepository);
    }

    // public TechnicalSkill add(TechnicalSkill technicalSkill){
    //     return technicalSkillRepository.save(technicalSkill);
    // } 

    // public TechnicalSkill update(TechnicalSkill technicalSkill){
    //     return technicalSkillRepository.save(technicalSkill);
    // } 


    // public void deactivate(Long id){
        
    //     TechnicalSkill technicalSkill = technicalSkillRepository.findById(id).get();
    //     technicalSkill.setActive(false);
    //     technicalSkillRepository.save(technicalSkill);
    // }

    // public void reactive(Long id){
    //     TechnicalSkill technicalSkill =  technicalSkillRepository.findById(id).get();
    //     technicalSkill.setActive(true);
    //     technicalSkillRepository.save(technicalSkill);
    // }

    // public List<TechnicalSkill> viewAll(){
    //     return technicalSkillRepository.findAll();
        
    // }



}
