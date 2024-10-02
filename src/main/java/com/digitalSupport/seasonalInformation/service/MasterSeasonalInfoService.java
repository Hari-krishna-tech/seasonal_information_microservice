package com.digitalSupport.seasonalInformation.service;


import com.digitalSupport.seasonalInformation.model.MasterSeasonalInfo;
import com.digitalSupport.seasonalInformation.repository.MasterSeasonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterSeasonalInfoService {
    private final MasterSeasonalInfoRepository repository;

    @Autowired
    public MasterSeasonalInfoService(MasterSeasonalInfoRepository theRepository) {
        this.repository = theRepository;
    }

    public List<MasterSeasonalInfo> getAllSeasonalInfo() {
        return repository.findAll();

    }


}
