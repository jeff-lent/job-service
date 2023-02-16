package com.xloop.resourceloop.createJob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Perks;

public interface PerksRepository extends JpaRepository<Perks,Long> {
    
    List<Perks> findAllByPerksNameInAndActiveIsTrue(List<String> benefitsPerksString );

    public List<Perks> findAllByPerksNameIn(List<String> benefitsPerksString);



}
