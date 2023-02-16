package com.xloop.resourceloop.createJob.Service.DropDownService;


import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Benefits;
import com.xloop.resourceloop.createJob.Model.DropDownModel.Perks;
import com.xloop.resourceloop.createJob.Repository.BenefitsRepository;
import com.xloop.resourceloop.createJob.Repository.PerksRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;

@Service
public class PerksService extends GenericDropDown<Perks, PerksRepository>  {


    public PerksService(PerksRepository perksRepository){
        super(perksRepository);
    }






}
