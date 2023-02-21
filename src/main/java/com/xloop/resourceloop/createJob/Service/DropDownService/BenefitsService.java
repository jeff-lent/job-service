package com.xloop.resourceloop.createJob.Service.DropDownService;


import org.springframework.stereotype.Service;

import com.xloop.resourceloop.createJob.Model.DropDownModel.Benefits;
import com.xloop.resourceloop.createJob.Repository.BenefitsRepository;
import com.xloop.resourceloop.createJob.ServiceInterface.GenericDropDown;

@Service
public class BenefitsService extends GenericDropDown<Benefits, BenefitsRepository>  {

    public BenefitsService(BenefitsRepository benefitsPerksRepository){
        super(benefitsPerksRepository);
    }

}
