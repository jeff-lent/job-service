package com.xloop.resourceloop.createJob.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
    Location findByLocationName(String location);
    
}
