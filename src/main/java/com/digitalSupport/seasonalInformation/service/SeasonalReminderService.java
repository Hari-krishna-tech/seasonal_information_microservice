package com.digitalSupport.seasonalInformation.service;

import com.digitalSupport.seasonalInformation.model.MasterSeasonalInfoForLogs;
import com.digitalSupport.seasonalInformation.model.SeasonalEmailLog;
import com.digitalSupport.seasonalInformation.repository.MasterSeasonalInfoForLogsRepository;
import com.digitalSupport.seasonalInformation.repository.SeasonalEmailLogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeasonalReminderService {
    private final MasterSeasonalInfoForLogsRepository seasonalInfoRepository;
    private final SeasonalEmailLogRepository emailLogRepository;
    private final EmailService emailService;

    @Autowired
    public SeasonalReminderService(MasterSeasonalInfoForLogsRepository seasonalInfoRepository,
                                   SeasonalEmailLogRepository emailLogRepository,
                                   EmailService emailService) {
        this.seasonalInfoRepository = seasonalInfoRepository;
        this.emailLogRepository = emailLogRepository;
        this.emailService = emailService;
    }

    @Transactional
    public void processAndSendReminders() throws IOException {
        LocalDate today = LocalDate.now();
        List<MasterSeasonalInfoForLogs> reminders = seasonalInfoRepository.findByReminderDate(today);

        for (MasterSeasonalInfoForLogs reminder : reminders) {
            String subject = "Seasonal Reminder: " + reminder.getOrigin().getOrigin() + " - " + reminder.getOrigin().getCommodity();
            String body = buildEmailBody(reminder);

            Set<String> toEmails = reminder.getRecipientsTo().stream()
                    .map((ele) -> ele.getEmailId())
                    .collect(Collectors.toSet());

            Set<String> ccEmails = reminder.getRecipientsCc().stream()
                    .map((ele) -> ele.getEmailId())
                    .collect(Collectors.toSet());

            boolean sendStatus = emailService.sendEmail(toEmails, ccEmails, subject, body);

            SeasonalEmailLog log = new SeasonalEmailLog();
            log.setSeasonalInfo(reminder);
            log.setEmailSendDateTime(LocalDateTime.now());
            log.setEmailSendStatus(sendStatus);
            log.setEmailSubject(subject);
            log.setEmailBody(body);

            emailLogRepository.save(log);
        }
    }

    private String buildEmailBody(MasterSeasonalInfoForLogs reminder) {
        // Implement email body construction logic
        return "Reminder for " + reminder.getOrigin().getOrigin() + " " + reminder.getOrigin().getCommodity() +
                " season from " + reminder.getSeasonFrom() + " to " + reminder.getSeasonTo();
    }
}
