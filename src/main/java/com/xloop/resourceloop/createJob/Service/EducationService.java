package com.xloop.resourceloop.createJob.Service;

import java.security.PublicKey;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.Education;
import com.xloop.resourceloop.createJob.Repository.EducationRepository;

@Service
public class EducationService {
    
    public EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository){
        this.educationRepository=educationRepository;
    }

    public Education addEducation(Education education){
        return educationRepository.save(education);

    }

    public List<Education> viewAllEducations(){
        return educationRepository.findAll();
        
    }

    public void deleteEducation(Long id){
        
        //jobRepository.deleteById(id);
       //List<Job> allJobs = jobRepository.findAll();
       //changing the value of isActive column.
        Education education = educationRepository.findById(id).get();
        education.setActive(false);
    //    jobRepository.save(pashaJob);
        educationRepository.save(education);
        
    }

    public void reactiveEducation(Long id){
        Education education =  educationRepository.findById(id).get();
        education.setActive(true);
        educationRepository.save(education);
    }


}
