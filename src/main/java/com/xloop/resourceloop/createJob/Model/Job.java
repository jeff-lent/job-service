package com.xloop.resourceloop.createJob.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    
    //for adding department in the list.
    private List<String> departments;
    
    //for adding responsibilities in the list
    private String responsibilities;

    private String designation;

    private String education;

    @Column(name = "experience_level")
    private int exp_level;

    //should be enum Type
    private String emp_category;

    private int vac_count;
    
    //should be enum Type
    private String gender;

    private List<String> skills;
    
    private List<String> location;

    //should be enum Type 
    private String traveling;

    private List<String> benefit_perks;

    //Should be Date Type
    private String post_date;

    //Should be Date Type
    private String close_date;
}
