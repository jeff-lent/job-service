package com.xloop.resourceloop.createJob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Education;

public interface EducationRepository extends JpaRepository<Education,Long>  {
    
    public List<Education> findAllByEducationNameIn(List<String> softSkills);
    List<Education> findAllByEducationNameInAndActiveIsTrue(List<String> educationString);



}
