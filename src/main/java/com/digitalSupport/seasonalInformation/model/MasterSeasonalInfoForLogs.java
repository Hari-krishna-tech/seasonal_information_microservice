package com.digitalSupport.seasonalInformation.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "master_seasonal_info")
public class MasterSeasonalInfoForLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "origin", nullable = false)
    private MasterOriginInfo origin;

    @Column(name = "region", nullable = false)
    private String region;

    @ManyToOne
    @JoinColumn(name = "entity", nullable = false)
    private MasterEntityInfo entity;

    @Column(name = "season_from", nullable = false)
    private String seasonFrom;

    @Column(name = "season_to", nullable = false)
    private String seasonTo;

    @Column(name = "reminder_date", nullable = false)
    private LocalDate reminderDate;

    @ManyToMany
    @JoinTable(
            name = "seasonal_email_recipients_to",
            joinColumns = @JoinColumn(name = "seasonal_info_id"),
            inverseJoinColumns = @JoinColumn(name = "business_user_id")
    )
    private Set<MasterBusinessUser> recipientsTo;

    @ManyToMany
    @JoinTable(
            name = "seasonal_email_recipients_cc",
            joinColumns = @JoinColumn(name = "seasonal_info_id"),
            inverseJoinColumns = @JoinColumn(name = "business_user_id")
    )
    private Set<MasterBusinessUser> recipientsCc;

    public MasterSeasonalInfoForLogs() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MasterOriginInfo getOrigin() {
        return origin;
    }

    public void setOrigin(MasterOriginInfo origin) {
        this.origin = origin;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public MasterEntityInfo getEntity() {
        return entity;
    }

    public void setEntity(MasterEntityInfo entity) {
        this.entity = entity;
    }

    public String getSeasonFrom() {
        return seasonFrom;
    }

    public void setSeasonFrom(String seasonFrom) {
        this.seasonFrom = seasonFrom;
    }

    public String getSeasonTo() {
        return seasonTo;
    }

    public void setSeasonTo(String seasonTo) {
        this.seasonTo = seasonTo;
    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDate reminderDate) {
        this.reminderDate = reminderDate;
    }

    public Set<MasterBusinessUser> getRecipientsTo() {
        return recipientsTo;
    }

    public void setRecipientsTo(Set<MasterBusinessUser> recipientsTo) {
        this.recipientsTo = recipientsTo;
    }

    public Set<MasterBusinessUser> getRecipientsCc() {
        return recipientsCc;
    }

    public void setRecipientsCc(Set<MasterBusinessUser> recipientsCc) {
        this.recipientsCc = recipientsCc;
    }
}
