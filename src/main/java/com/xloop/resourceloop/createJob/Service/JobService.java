package com.xloop.resourceloop.createJob.Service;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.Job;
import com.xloop.resourceloop.createJob.Model.SoftSkill;
import com.xloop.resourceloop.createJob.Repository.JobRepository;
import com.xloop.resourceloop.createJob.Repository.SoftSkillRepository;

@Service
public class JobService {
    
    private final JobRepository jobRepository;

    private final SoftSkillRepository softSkillRepository;

    public JobService(JobRepository jobRepository ,SoftSkillRepository softSkillRepository ) {
        this.jobRepository = jobRepository;
        this.softSkillRepository= softSkillRepository;
    }

    public Job save(Job job) {
        job.setPostDate(new Date());
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        
        job.getSoftSkills().forEach(
            ss -> 
            {
                softSkillRepository.findByName(ss.getSoftSkill()).orElseGet(() -> softSkillRepository.save(ss));
                ss.setJobs(Set.of(job));
            }
            );

        // Course savedCourse = courseRepository.findByName(course.getName()).orElseGet(() -> courseRepository.save(course));

        // student.getCourses().add(savedCourse);
        
        job.getTechnicalSkills().forEach(ts -> ts.setJob(job));
        return jobRepository.save(job);
    }

    public Job update(Job job){
        job.setPostDate(new Date());
        job.getResponsibilitiess().forEach(respons -> respons.setJob(job));
        job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        job.getEducations().forEach(respons -> respons.setJob(job));
        //job.getSoftSkills().forEach(ss -> ss.setJob(job));
        job.getTechnicalSkills().forEach(ts -> ts.setJob(job));
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
        pashaJob.setPasha(false);
       jobRepository.save(pashaJob);
        
    }
    
    public Optional<Job> getAJob(Long id) throws Exception{
        return jobRepository.findById(id);
        
    }
    
    public Optional<Job> getAJob(Long id) throws Exception{
        return jobRepository.findById(id);
        
    }

    public List<Job> viewAllJob(){
      List<Job> allJobs =  jobRepository.findAll();
     List<Job> activeJobs = allJobs.stream()
     .filter(p -> p.isPasha() == true)
     .collect(Collectors.toList());   
     return activeJobs; 
    }

    public List<Job> viewDeactivatedJobs() {
        List<Job> allJobs =  jobRepository.findAll();
        List<Job> deactivatedJobs = allJobs.stream().filter(a-> a.isPasha()==false).collect(Collectors.toList());
        return deactivatedJobs;
    }

    
}
