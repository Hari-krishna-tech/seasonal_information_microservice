package com.digitalSupport.seasonalInformation.repository;


import com.digitalSupport.seasonalInformation.model.SeasonalEmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonalEmailLogRepository extends JpaRepository<SeasonalEmailLog, Integer> {
}
