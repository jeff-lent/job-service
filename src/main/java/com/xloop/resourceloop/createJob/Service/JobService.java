package com.xloop.resourceloop.createJob.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Model.SoftSkill;
import com.xloop.resourceloop.createJob.Repository.JobRepository;
import com.xloop.resourceloop.createJob.Repository.SoftSkillRepository;

@Service
@Transactional
public class JobService {
    
    private final JobRepository jobRepository;

    private final SoftSkillRepository softSkillRepository;

    @Autowired
    public JobService(JobRepository jobRepository ,SoftSkillRepository softSkillRepository ) {
        this.jobRepository = jobRepository;
        this.softSkillRepository= softSkillRepository;
    }

    public Job save(Job job) {
        job.setPostDate(new Date());
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        job.getTechnicalSkills().forEach(ts -> ts.setJob(job));

        List<String> softSkillString = new ArrayList<String>();
        job.getSoftSkills().forEach(ss -> softSkillString.add(ss.getSoftSkill()));
        job.setSoftSkills(null);
        jobRepository.save(job);
        
        Iterable<SoftSkill> allSoftSkill = softSkillRepository.findAllBySoftSkillIn(softSkillString);
        allSoftSkill.forEach( ss->ss.addJob(job) );
        job.setSoftSkills(new HashSet<>(softSkillRepository.saveAll(allSoftSkill)) );
        return jobRepository.save(job);        
    }

    public Job update(Job job){
        job.setPostDate(new Date());
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        job.getTechnicalSkills().forEach(ts -> ts.setJob(job));

        // job.getSoftSkills().forEach(ss -> Set.of(job));
        // return jobRepository.save(job);
        
        List<String> softSkillString = new ArrayList<String>();
        job.getSoftSkills().forEach(ss -> softSkillString.add(ss.getSoftSkill()));
        job.setSoftSkills(null);
        jobRepository.save(job);
        
        Iterable<SoftSkill> allSoftSkill = softSkillRepository.findAllBySoftSkillIn(softSkillString);
        allSoftSkill.forEach( ss->ss.addJob(job) );
        job.setSoftSkills(new HashSet<>(softSkillRepository.saveAll(allSoftSkill)) );
        return jobRepository.save(job);        
    }

    
    public Job getJobById(Long id){
        return jobRepository.findById(id).get();
    }


    public void delete(Long id){
        
        //jobRepository.deleteById(id);
       //List<Job> allJobs = jobRepository.findAll();
       //changing the value of isActive column.
        Job pashaJob =  jobRepository.findById(id).get();
        pashaJob.setActive(false);
       jobRepository.save(pashaJob);
        
    }
    

    public void autoDeleteJob(){
        try {
            jobRepository.autoDeleteJob(new Date());
            return;
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }
  
    
    public Optional<Job> getAJob(Long id) throws Exception{
        return jobRepository.findById(id);
        
    }

    public List<Job> viewAllJob(){
        return jobRepository.findAll();
    //   List<Job> allJobs =  jobRepository.findAll();
    //  List<Job> activeJobs = allJobs.stream()
    //  .filter(p -> p.isActive() == true)
    //  .collect(Collectors.toList());   
    //  return activeJobs; 
    }

    public List<Job> viewDeactivatedJobs() {
        List<Job> allJobs =  jobRepository.findAll();
        List<Job> deactivatedJobs = allJobs.stream().filter(a-> a.isActive()==false).collect(Collectors.toList());
        return deactivatedJobs;
    }

    
}
