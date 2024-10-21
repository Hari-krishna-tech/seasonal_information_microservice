package com.digitalSupport.seasonalInformation.config;

import com.digitalSupport.seasonalInformation.service.SeasonalReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SeasonalReminderScheduler {

    private final SeasonalReminderService seasonalReminderService;

    @Autowired
    public SeasonalReminderScheduler(SeasonalReminderService seasonalReminderService) {
        this.seasonalReminderService = seasonalReminderService;
    }

    @Scheduled(cron = "0 0 0 * * ?") // run at midnight every day
    public void sendDailyReminders() throws IOException {
        seasonalReminderService.processAndSendReminders();
    }
}
