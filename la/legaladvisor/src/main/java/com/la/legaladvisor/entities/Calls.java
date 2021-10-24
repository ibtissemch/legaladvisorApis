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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "calls")
public class Calls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @Column(name = "creationDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime creationDate;
    @Basic(optional = false)
    @Column(name = "sentDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime sentDate;
    @Basic(optional = false)
    @Column(name = "state")
    private int state;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "meetingDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime meetingDate;
    @Basic(optional = false)
    @Column(name = "with_inspection")
    private boolean withInspection;
    @Column(name = "duration_inspec")
    private int durationInspec;
    @Basic(optional = false)
    @Column(name = "inspection_date")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime inspectionDate;
    @JoinColumn(name = "partid", referencedColumnName = "id")
    @ManyToOne
    private Parts part;

    public Calls() {
    }

    public Calls(Long id) {
        this.id = id;
    }

    public Calls(Long id, LocalDateTime creationDate, LocalDateTime sentDate, int state, int duration, LocalDateTime meetingDate) {
        this.id = id;
        this.creationDate = creationDate;
        this.sentDate = sentDate;
        this.state = state;
        this.duration = duration;
        this.meetingDate = meetingDate;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate (LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate (LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDateTime getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate (LocalDateTime meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Parts getPartid() {
        return part;
    }

    public void setPartid(Parts partid) {
        this.part = partid;
    }

    public boolean isWithInspection() {
        return withInspection;
    }

    public void setWithInspection(boolean withInspection) {
        this.withInspection = withInspection;
    }

    public int getDurationInspec() {
        return durationInspec;
    }

    public void setDurationInspec(int durationInspec) {
        this.durationInspec = durationInspec;
    }

    public LocalDateTime getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDateTime inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public Parts getPart() {
        return part;
    }

    public void setPart(Parts part) {
        this.part = part;
    }
}