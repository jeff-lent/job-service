package com.xloop.resourceloop.createJob.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.SoftSkill;

public interface SoftSkillRepository extends JpaRepository<SoftSkill,Long>{
    
    public Optional<SoftSkill> findBySoftSkill(String softSkill);
    public List<SoftSkill> findAllBySoftSkillIn(List<String> softSkills);
    // public List<SoftSkill> findAllByActiveIsTrue();

    List<SoftSkill> findAllBySoftSkillInAndActiveIsTrue(List<String> softSkillString);

//     @Query("SELECT u FROM User u WHERE u.email = ?1")
//   public SoftSkill activeJob(String email);
    
    // public Iterable<SoftSkill> findAllBySoftSkill(Iterable<SoftSkill> softSkills);

}
