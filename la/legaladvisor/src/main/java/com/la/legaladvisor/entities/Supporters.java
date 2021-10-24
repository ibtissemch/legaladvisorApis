/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.la.legaladvisor.convertors.LocalDateTimeAttributeConverter;
import com.la.legaladvisor.convertors.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "supporters")
public class Supporters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "notes")
    private String notes;
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "creationDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime creationDate;
    @Basic(optional = false)
    @Column(name = "lastUpdateDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lastUpdateDate;
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "mission", referencedColumnName = "id")
    @ManyToOne
    private Mission mission;

    public Supporters() {
    }

    public Supporters(Long id) {
        this.id = id;
    }

    public Supporters(Long id, LocalDateTime creationDate, LocalDateTime lastUpdateDate) {
        this.id = id;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
