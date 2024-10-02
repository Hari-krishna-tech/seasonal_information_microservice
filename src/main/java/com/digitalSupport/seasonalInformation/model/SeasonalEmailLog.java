package com.digitalSupport.seasonalInformation.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "seasonal_email_logs")
public class SeasonalEmailLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "seasonal_info", nullable = false)
    private MasterSeasonalInfoForLogs seasonalInfo;

    @Column(name = "email_send_date_time", nullable = false)
    private LocalDateTime emailSendDateTime;

    @Column(name = "email_send_status", nullable = false)
    private boolean emailSendStatus;

    @Column(name = "email_subject", nullable = false)
    private String emailSubject;

    @Column(name = "email_body", nullable = false, length = 1000)
    private String emailBody;

    public SeasonalEmailLog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MasterSeasonalInfoForLogs getSeasonalInfo() {
        return seasonalInfo;
    }

    public void setSeasonalInfo(MasterSeasonalInfoForLogs seasonalInfo) {
        this.seasonalInfo = seasonalInfo;
    }

    public LocalDateTime getEmailSendDateTime() {
        return emailSendDateTime;
    }

    public void setEmailSendDateTime(LocalDateTime emailSendDateTime) {
        this.emailSendDateTime = emailSendDateTime;
    }

    public boolean isEmailSendStatus() {
        return emailSendStatus;
    }

    public void setEmailSendStatus(boolean emailSendStatus) {
        this.emailSendStatus = emailSendStatus;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }
}
