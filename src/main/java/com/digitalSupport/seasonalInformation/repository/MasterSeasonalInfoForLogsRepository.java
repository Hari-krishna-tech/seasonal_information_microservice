package com.digitalSupport.seasonalInformation.repository;

import com.digitalSupport.seasonalInformation.model.MasterSeasonalInfoForLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MasterSeasonalInfoForLogsRepository extends JpaRepository<MasterSeasonalInfoForLogs, Integer> {
    List<MasterSeasonalInfoForLogs> findByReminderDate(LocalDate reminderDate);
}
