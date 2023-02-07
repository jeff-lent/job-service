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
import com.xloop.resourceloop.createJob.Model.TechnicalSkill;
import com.xloop.resourceloop.createJob.Repository.JobRepository;
import com.xloop.resourceloop.createJob.Repository.SoftSkillRepository;
import com.xloop.resourceloop.createJob.Repository.TechnicalSkillRepository;

@Service
@Transactional
public class JobService {
    
    private final JobRepository jobRepository;

    private final SoftSkillRepository softSkillRepository;

    private final TechnicalSkillRepository technicalSkillRepository;

    @Autowired
    public JobService(JobRepository jobRepository ,SoftSkillRepository softSkillRepository , TechnicalSkillRepository technicalSkillRepository ) {
        this.jobRepository = jobRepository;
        this.softSkillRepository= softSkillRepository;
        this.technicalSkillRepository = technicalSkillRepository;
    }

    public Job save(Job job) {
        job.setPostDate(new Date());
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        //job.getTechnicalSkills().forEach(ts -> ts.setJob(job));
        
        List<String> technicalSkillString = new ArrayList<String>();
        job.getTechnicalSkills().forEach(ts -> technicalSkillString.add(ts.getTechnicalSkill()));   
        //validation
        job.setTechnicalSkills(null);
        // 
       // jobRepository.save(job);

        Iterable<TechnicalSkill> allTechnicalSkill = technicalSkillRepository.findAllByTechnicalSkillInAndActiveIsTrue(technicalSkillString);
        // allSoftSkill.forEach( ss->ss.addJob(job) );
        allTechnicalSkill.forEach(ts->ts.addJob(job));
        // job.setSoftSkills(new HashSet<>(softSkillRepository.saveAll(allSoftSkill)) );
         job.setTechnicalSkills(new HashSet<>(technicalSkillRepository.saveAll(allTechnicalSkill)));   



        List<String> softSkillString = new ArrayList<String>();
        job.getSoftSkills().forEach(ss -> softSkillString.add(ss.getSoftSkill()));
        //validation
        job.setSoftSkills(null);
        jobRepository.save(job);
        
        Iterable<SoftSkill> allSoftSkill = softSkillRepository.findAllBySoftSkillInAndActiveIsTrue(softSkillString);
        allSoftSkill.forEach( ss->ss.addJob(job) );
        job.setSoftSkills(new HashSet<>(softSkillRepository.saveAll(allSoftSkill)) );

        return jobRepository.save(job);        
    }

    public Job update(Job job){
        job.setPostDate(new Date());
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        //job.getTechnicalSkills().forEach(ts -> ts.setJob(job));

        // job.getSoftSkills().forEach(ss -> Set.of(job));
        // return jobRepository.save(job);
        
        List<String> technicalSkillString = new ArrayList<String>();
        job.getTechnicalSkills().forEach(ts->technicalSkillString.add(ts.getTechnicalSkill()));
        job.setTechnicalSkills(null);
        jobRepository.save(job);        

        Iterable<TechnicalSkill> allTechnicalSkill = technicalSkillRepository.findAllByTechnicalSkillIn(technicalSkillString);
        allTechnicalSkill.forEach( ts->ts.addJob(job) );
        job.setTechnicalSkills(new HashSet<>(technicalSkillRepository.saveAll(allTechnicalSkill)) );




        List<String> softSkillString = new ArrayList<String>();
        job.getSoftSkills().forEach(ss -> softSkillString.add(ss.getSoftSkill()));
        job.setSoftSkills(null);
        jobRepository.save(job);
        
        Iterable<SoftSkill> allSoftSkill = softSkillRepository.findAllBySoftSkillIn(softSkillString);
        allSoftSkill.forEach( ss->ss.addJob(job));
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
