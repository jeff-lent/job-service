package com.xloop.resourceloop.createJob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.Education;

public interface EducationRepository extends JpaRepository<Education,Long>  {
    
    public List<Education> findAllByEducationIn(List<String> softSkills);
    // public List<SoftSkill> findAllByActiveIsTrue();

    List<Education> findAllByEducationInAndActiveIsTrue(List<String> educationString);



}
