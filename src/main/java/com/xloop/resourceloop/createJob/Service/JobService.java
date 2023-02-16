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
import com.xloop.resourceloop.createJob.Model.DropDownModel.Benefits;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Department;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Education;
import com.xloop.resourceloop.createJob.Model.DropDownModel.JobType;
import com.xloop.resourceloop.createJob.Model.DropDownModel.SoftSkill;
import com.xloop.resourceloop.createJob.Model.DropDownModel.TechnicalSkill;
import com.xloop.resourceloop.createJob.Repository.BenefitsRepository;
import com.xloop.resourceloop.createJob.Repository.DepartmentRepository;
import com.xloop.resourceloop.createJob.Repository.EducationRepository;
import com.xloop.resourceloop.createJob.Repository.JobRepository;
import com.xloop.resourceloop.createJob.Repository.JobTypeRepository;
import com.xloop.resourceloop.createJob.Repository.SoftSkillRepository;
import com.xloop.resourceloop.createJob.Repository.TechnicalSkillRepository;

@Service
@Transactional
public class JobService {

    private final JobRepository jobRepository;

    private final SoftSkillRepository softSkillRepository;

    private final TechnicalSkillRepository technicalSkillRepository;

    private final EducationRepository educationRepository;

    private final BenefitsRepository benefitsPerksRepository;

    private final DepartmentRepository departmentRepository;
    
    private final JobTypeRepository jobTypeRepository;


    public JobService(JobRepository jobRepository, SoftSkillRepository softSkillRepository,
            TechnicalSkillRepository technicalSkillRepository, EducationRepository educationRepository,
            BenefitsRepository benefitsPerksRepository, DepartmentRepository departmentRepository,
            JobTypeRepository jobTypeRepository) {
        this.jobRepository = jobRepository;
        this.softSkillRepository = softSkillRepository;
        this.technicalSkillRepository = technicalSkillRepository;
        this.educationRepository = educationRepository;
        this.benefitsPerksRepository = benefitsPerksRepository;
        this.departmentRepository = departmentRepository;
        this.jobTypeRepository = jobTypeRepository;
    }




    public Job save(Job job) {
        job.setPostDate(new Date());
        // job.getBenefitPerkss().forEach(respons -> respons.setJob(job));

        List<String> jobTypeString = new ArrayList<String>();
        job.getJobTypes().forEach(ben -> jobTypeString.add(ben.getJobTypeName()));


        job.setJobTypes(null);
        

        Iterable<JobType> allJobType = jobTypeRepository
                .findAllByJobTypeNameInAndActiveIsTrue(jobTypeString);

        allJobType.forEach(ben -> ben.addJob(job));
        job.setJobTypes(new HashSet<>(jobTypeRepository.saveAll(allJobType)));




        List<String> benefitsPerksString = new ArrayList<String>();
        job.getBenefits().forEach(ben -> benefitsPerksString.add(ben.getBenefitsName()));


        job.setBenefits(null);
        

        Iterable<Benefits> allBenefitsPerks = benefitsPerksRepository
                .findAllByBenefitsNameInAndActiveIsTrue(benefitsPerksString);

        allBenefitsPerks.forEach(ben -> ben.addJob(job));
        job.setBenefits(new HashSet<>(benefitsPerksRepository.saveAll(allBenefitsPerks)));



        // job.getEducations().forEach(respons -> respons.setJob(job));

        List<String> educationString = new ArrayList<String>();
        job.getEducations().forEach(edu -> educationString.add(edu.getEducationName()));
        job.setEducations(null);

        Iterable<Education> allEducation = educationRepository.findAllByEducationNameInAndActiveIsTrue(educationString);
        allEducation.forEach(edu -> edu.addJob(job));

        job.setEducations(new HashSet<>(educationRepository.saveAll(allEducation)));

        // job.getTechnicalSkills().forEach(ts -> ts.setJob(job));
        //////////////////////////////////////////////////////////////////////
        List<String> technicalSkillString = new ArrayList<String>();
        job.getTechnicalSkills().forEach(ts -> technicalSkillString.add(ts.getTechnicalSkillName()));
        // validation
        job.setTechnicalSkills(null);

        //
        // jobRepository.save(job);

        Iterable<TechnicalSkill> allTechnicalSkill = technicalSkillRepository
                .findAllByTechnicalSkillNameInAndActiveIsTrue(technicalSkillString);
        // allSoftSkill.forEach( ss->ss.addJob(job) );
        allTechnicalSkill.forEach(ts -> ts.addJob(job));
        // job.setSoftSkills(new HashSet<>(softSkillRepository.saveAll(allSoftSkill)) );
        job.setTechnicalSkills(new HashSet<>(technicalSkillRepository.saveAll(allTechnicalSkill)));

        //////////////////////////////////////////////////////////////////////////////////////////

        List<String> softSkillString = new ArrayList<String>();
        job.getSoftSkills().forEach(ss -> softSkillString.add(ss.getSoftSkillName()));
        // validation
        job.setSoftSkills(null);
        // jobRepository.save(job);

        Iterable<SoftSkill> allSoftSkill = softSkillRepository.findAllBySoftSkillNameInAndActiveIsTrue(softSkillString);
        allSoftSkill.forEach(ss -> ss.addJob(job));
        job.setSoftSkills(new HashSet<>(softSkillRepository.saveAll(allSoftSkill)));


        // Department department = departmentRepository.findByDepartmentName(job.getDepartment().getDepartmentName());
        
        // job.setDepartment(department);

        return jobRepository.save(job);
    }






    public Job update(Job job) {
        job.setPostDate(new Date());
        // job.getBenefitPerkss().forEach(respons -> respons.setJob(job));
        // job.getEducations().forEach(respons -> respons.setJob(job));


        List<String> jobTypeString = new ArrayList<String>();
        job.getJobTypes().forEach(ben -> jobTypeString.add(ben.getJobTypeName()));


        job.setJobTypes(null);
        

        Iterable<JobType> allJobType = jobTypeRepository
                .findAllByJobTypeNameInAndActiveIsTrue(jobTypeString);

        allJobType.forEach(ben -> ben.addJob(job));
        job.setJobTypes(new HashSet<>(jobTypeRepository.saveAll(allJobType)));

        

        List<String> benefitsPerksString = new ArrayList<String>();
        // job.getBenefitPerkss().forEach(ben->benefitsPerksString.add(ben.getBenefitPerks()));
        job.getBenefits().forEach(ben -> benefitsPerksString.add(ben.getBenefitsName()));
        job.setBenefits(null);
        // jobRepository.save(job);

        // job.setTechnicalSkills(null);
        // jobRepository.save(job);

        Iterable<Benefits> allBenefitsPerks = benefitsPerksRepository.findAllByBenefitsNameInAndActiveIsTrue(benefitsPerksString);
        allBenefitsPerks.forEach(ben -> ben.addJob(job));
        job.setBenefits(new HashSet<>(benefitsPerksRepository.saveAll(allBenefitsPerks)));

        List<String> educationString = new ArrayList<String>();
        job.getEducations().forEach(edu -> educationString.add(edu.getEducationName()));
        job.setEducations(null);
        // jobRepository.save(job);

        Iterable<Education> allEducation = educationRepository.findAllByEducationNameInAndActiveIsTrue(educationString);
        allEducation.forEach(edu -> edu.addJob(job));
        // job.setEducations(null);
        job.setEducations(new HashSet<>(educationRepository.saveAll(allEducation)));
        // job.getTechnicalSkills().forEach(ts -> ts.setJob(job));

        // job.getSoftSkills().forEach(ss -> Set.of(job));
        // return jobRepository.save(job);

        List<String> technicalSkillString = new ArrayList<String>();
        job.getTechnicalSkills().forEach(ts -> technicalSkillString.add(ts.getTechnicalSkillName()));
        job.setTechnicalSkills(null);
        // jobRepository.save(job);

        Iterable<TechnicalSkill> allTechnicalSkill = technicalSkillRepository
                .findAllByTechnicalSkillNameInAndActiveIsTrue(technicalSkillString);
        allTechnicalSkill.forEach(ts -> ts.addJob(job));
        job.setTechnicalSkills(new HashSet<>(technicalSkillRepository.saveAll(allTechnicalSkill)));

        List<String> softSkillString = new ArrayList<String>();
        job.getSoftSkills().forEach(ss -> softSkillString.add(ss.getSoftSkillName()));
        job.setSoftSkills(null);
        // jobRepository.save(job);

        Iterable<SoftSkill> allSoftSkill = softSkillRepository.findAllBySoftSkillNameInAndActiveIsTrue(softSkillString);
        allSoftSkill.forEach(ss -> ss.addJob(job));
        job.setSoftSkills(new HashSet<>(softSkillRepository.saveAll(allSoftSkill)));

        return jobRepository.save(job);
    }







    public Job getJobById(Long id) {
        return jobRepository.findById(id).get();
    }


    public void delete(Long id) {

        // jobRepository.deleteById(id);
        // List<Job> allJobs = jobRepository.findAll();
        // changing the value of isActive column.
        Job pashaJob = jobRepository.findById(id).get();
        pashaJob.setActive(false);
        jobRepository.save(pashaJob);

    }

    public void autoDeleteJob() {
        try {
            jobRepository.autoDeleteJob(new Date());
            return;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public Optional<Job> getAJob(Long id) throws Exception {
        return jobRepository.findById(id);

    }

    public List<Job> viewAllJob() {
        return jobRepository.findAll();
        // List<Job> allJobs = jobRepository.findAll();
        // List<Job> activeJobs = allJobs.stream()
        // .filter(p -> p.isActive() == true)
        // .collect(Collectors.toList());
        // return activeJobs;
    }

    public List<Job> viewDeactivatedJobs() {
        List<Job> allJobs = jobRepository.findAll();
        List<Job> deactivatedJobs = allJobs.stream().filter(a -> a.isActive() == false).collect(Collectors.toList());
        return deactivatedJobs;
    }

}
