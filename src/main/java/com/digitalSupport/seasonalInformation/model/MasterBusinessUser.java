package com.digitalSupport.seasonalInformation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "master_")
public class MasterBusinessUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email_id")
    private String emailId;

    @ManyToOne
    @JoinColumn(name = "entity", nullable = false)
    private MasterEntityInfo entity;

    public MasterBusinessUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public MasterEntityInfo getEntity() {
        return entity;
    }

    public void setEntity(MasterEntityInfo entity) {
        this.entity = entity;
    }
}
