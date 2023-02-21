package com.xloop.resourceloop.createJob.Model.DropDownModel;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xloop.resourceloop.createJob.Model.Job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter

public class SoftSkill implements GenericDropDownModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;

    @Column(nullable = false, unique = true)
    @Getter @Setter private String softSkillName;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToMany(mappedBy = "softSkills",fetch = FetchType.LAZY)
    private Set<Job> jobs;



    
    public void addJob(Job job) {
        if (this.jobs == null) {
            this.jobs = new HashSet<>();
        }
        this.jobs.add(job);
    }
    
    public SoftSkill(String SoftSkill){
        this.softSkillName = SoftSkill;
    }
    
    public SoftSkill(){
    }
    
    public boolean active=true;

    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
