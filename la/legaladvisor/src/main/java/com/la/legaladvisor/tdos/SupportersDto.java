/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.tdos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class SupportersDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String notes;
    private String type;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private String url;
    private MissionsDto mission;

    public SupportersDto() {
    }

    public SupportersDto(Long id) {
        this.id = id;
    }

    public SupportersDto(String name, String notes, String type, LocalDateTime creationDate, LocalDateTime lastUpdateDate, String url) {
        this.name = name;
        this.notes = notes;
        this.type = type;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.url = url;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public MissionsDto getMission() {
        return mission;
    }

    public void setMission(MissionsDto mission) {
        this.mission = mission;
    }
}
