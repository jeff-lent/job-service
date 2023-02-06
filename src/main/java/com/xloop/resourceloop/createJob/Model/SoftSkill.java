package com.xloop.resourceloop.createJob.Model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class SoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;

    @Column(nullable = false, unique = true)
    @Getter @Setter private String softSkill;

    // @JsonIgnore
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "job_id")
    // @Getter @Setter private set<Job> job;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToMany(mappedBy = "softSkills",fetch = FetchType.LAZY)
    private Set<Job> jobs;


    private boolean active=true;


    
    public void addJob(Job job) {
        if (this.jobs == null) {
            this.jobs = new HashSet<>();
        }
        this.jobs.add(job);
    }
    
    public SoftSkill(String SoftSkill){
        this.softSkill = SoftSkill;
    }
    
    public SoftSkill(){
    }

}
