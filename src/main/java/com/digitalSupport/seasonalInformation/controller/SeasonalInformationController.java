package com.digitalSupport.seasonalInformation.controller;

import com.digitalSupport.seasonalInformation.model.MasterSeasonalInfo;
import com.digitalSupport.seasonalInformation.model.SeasonalEmailLog;
import com.digitalSupport.seasonalInformation.service.MasterSeasonalInfoService;
import com.digitalSupport.seasonalInformation.service.SeasonalEmailLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/seasonal-info")
public class SeasonalInformationController {

    @Autowired
    private MasterSeasonalInfoService service;

    @Autowired
    private SeasonalEmailLogService seasonalEmailLogService;



    @GetMapping("/list")
    public List<MasterSeasonalInfo> getAllSeasonalInfo() {
        return service.getAllSeasonalInfo();
    }

    @GetMapping("/logs")
    public List<SeasonalEmailLog> getAllSeasonalEmailLogs() {
        return seasonalEmailLogService.getAllSeasonalEmailLog();
    }


}
