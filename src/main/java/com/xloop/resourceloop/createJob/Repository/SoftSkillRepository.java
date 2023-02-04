package com.xloop.resourceloop.createJob.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.SoftSkill;

public interface SoftSkillRepository extends JpaRepository<SoftSkill,Long>{
    
    public Optional<SoftSkill> findBySoftSkill(String softSkill);
    public List<SoftSkill> findAllBySoftSkillIn(List<String> softSkills);
    // public Iterable<SoftSkill> findAllBySoftSkill(Iterable<SoftSkill> softSkills);

}
