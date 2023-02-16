package com.xloop.resourceloop.createJob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.DropDownModel.TechnicalSkill;

public interface TechnicalSkillRepository extends JpaRepository<TechnicalSkill,Long> {
    
    List<TechnicalSkill> findAllByTechnicalSkillNameInAndActiveIsTrue(List<String> softSkillString);

    public List<TechnicalSkill> findAllByTechnicalSkillNameIn(List<String> softSkills);


}
 