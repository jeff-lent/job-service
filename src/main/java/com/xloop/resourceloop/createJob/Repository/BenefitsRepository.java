package com.xloop.resourceloop.createJob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Benefits;

public interface BenefitsRepository extends JpaRepository<Benefits,Long> {
    
    List<Benefits> findAllByBenefitsNameInAndActiveIsTrue(List<String> benefitsPerksString );

    public List<Benefits> findAllByBenefitsNameIn(List<String> benefitsPerksString);



}
