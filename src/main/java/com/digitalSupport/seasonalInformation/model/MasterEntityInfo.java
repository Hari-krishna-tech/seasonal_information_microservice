package com.digitalSupport.seasonalInformation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "master_entity_info")
public class MasterEntityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public MasterEntityInfo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
