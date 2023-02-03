package com.xloop.resourceloop.createJob.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.SoftSkill;

public interface SoftSkillRepository extends JpaRepository<SoftSkill,Long>{
    Optional<SoftSkill> findByName(String softSkill);
}
