package com.digitalSupport.seasonalInformation.controller;

import com.digitalSupport.seasonalInformation.model.MasterSeasonalInfo;
import com.digitalSupport.seasonalInformation.model.SeasonalEmailLog;
import com.digitalSupport.seasonalInformation.service.MasterSeasonalInfoService;
import com.digitalSupport.seasonalInformation.service.SeasonalEmailLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()

@RestController
@RequestMapping("/seasonal-info")
public class SeasonalInformationController {

    @Autowired
    private MasterSeasonalInfoService service;

    @Autowired
    private SeasonalEmailLogService seasonalEmailLogService;


    @PreAuthorize("hasRole('ROLE_SEASONAL_INFO')")
    @GetMapping("/list")
    public List<MasterSeasonalInfo> getAllSeasonalInfo() {
        return service.getAllSeasonalInfo();
    }

    @PreAuthorize("hasRole('ROLE_SEASONAL_INFO')")
    @GetMapping("/list/{product}")
    public List<MasterSeasonalInfo> getSeasonalInfoByProduct(@PathVariable String product) {
        return service.getSeasonalInfoByProduct(product);
    }

    @PreAuthorize("hasRole('ROLE_SEASONAL_INFO')")
    @GetMapping("/logs")
    public List<SeasonalEmailLog> getAllSeasonalEmailLogs() {
        return seasonalEmailLogService.getAllSeasonalEmailLog();
    }


}
