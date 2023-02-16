package com.xloop.resourceloop.createJob.Service.DropDownService;

import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Location;
import com.xloop.resourceloop.createJob.Repository.LocationRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;

@Service
public class LocationService  extends GenericDropDown<Location, LocationRepository>  {
    public LocationService(LocationRepository locationRepository){
        super(locationRepository);
    }
}
