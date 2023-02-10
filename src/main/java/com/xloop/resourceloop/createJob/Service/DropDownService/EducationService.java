package com.xloop.resourceloop.createJob.Service.DropDownService;

import java.security.PublicKey;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.Education;
import com.xloop.resourceloop.createJob.Repository.EducationRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.InterfaceForDropDowns;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;

@Service
public class EducationService extends GenericDropDown<Education, EducationRepository>  {
    
    // private EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository){
        // this.educationRepository = educationRepository;
        super(educationRepository);
    }
    // public EducationRepository educationRepository;

    // public EducationService(EducationRepository educationRepository){
    //     this.educationRepository=educationRepository;
    // }

    // public Education add(Education education){
    //     return educationRepository.save(education);

    // }

    // public Education update(Education education){
    //     return educationRepository.save(education);

    // }

    // public List<Education> viewAll(){
    //     return educationRepository.findAll();
        
    // }

    // public void deactivate(Long id){
        
    //     Education education = educationRepository.findById(id).get();
    //     education.setActive(false);
    //     educationRepository.save(education);
        
    // }

    // public void reactive(Long id){
    //     Education education =  educationRepository.findById(id).get();
    //     education.setActive(true);
    //     educationRepository.save(education);
    // }


}
