package com.digitalSupport.seasonalInformation.service;

import com.digitalSupport.seasonalInformation.model.SeasonalEmailLog;
import com.digitalSupport.seasonalInformation.repository.SeasonalEmailLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonalEmailLogService {
    @Autowired
    private SeasonalEmailLogRepository seasonalEmailLogRepository;

    public List<SeasonalEmailLog> getAllSeasonalEmailLog() {
        return seasonalEmailLogRepository.findAll();
    }

}
