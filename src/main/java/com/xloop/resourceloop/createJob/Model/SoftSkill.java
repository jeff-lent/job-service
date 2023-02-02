package com.xloop.resourceloop.createJob.Model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class SoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
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
    
    public SoftSkill(String SoftSkill){
        this.softSkill = SoftSkill;
    }
    
    public SoftSkill(){
    }

}
