package com.xloop.resourceloop.createJob.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.TechnicalSkill;

public interface TechnicalSkillRepository extends JpaRepository<TechnicalSkill,Long> {
    
}
