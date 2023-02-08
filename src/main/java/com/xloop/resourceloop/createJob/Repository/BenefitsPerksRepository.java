package com.xloop.resourceloop.createJob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.BenefitsPerks;

public interface BenefitsPerksRepository extends JpaRepository<BenefitsPerks,Long> {
    
    List<BenefitsPerks> findAllByBenefitPerksInAndActiveIsTrue(List<String> benefitsPerksString );

    public List<BenefitsPerks> findAllByBenefitPerksIn(List<String> benefitsPerksString);



}
