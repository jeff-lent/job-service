package com.xloop.resourceloop.createJob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.TechnicalSkill;

public interface TechnicalSkillRepository extends JpaRepository<TechnicalSkill,Long> {
    
    List<TechnicalSkill> findAllByTechnicalSkillInAndActiveIsTrue(List<String> softSkillString);

    public List<TechnicalSkill> findAllByTechnicalSkillIn(List<String> softSkills);


}
