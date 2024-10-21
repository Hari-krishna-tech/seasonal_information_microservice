package com.digitalSupport.seasonalInformation.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "master_seasonal_info")
public class MasterSeasonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin", nullable = false)
    private MasterOriginInfo origin;

    @Column(nullable = false)
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

    @Column(name = "product", nullable = false)
    private String product;

    public MasterSeasonalInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
