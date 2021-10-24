/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.tdos;

import java.io.Serializable;

/**
 * @author Admin
 */
public class CallsDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String url;
    private String creationDate;
    private String sentDate;
    private int state;
    private int duration;
    private String meetingDate;
    private PartsDto part;

    public CallsDto() {
    }

    public CallsDto(Long id) {
        this.id = id;
    }

    public CallsDto(String name, String url, String creationDate, String sentDate, int state, int duration, String meetingDate, PartsDto part) {
        this.name = name;
        this.url = url;
        this.creationDate = creationDate;
        this.sentDate = sentDate;
        this.state = state;
        this.duration = duration;
        this.meetingDate = meetingDate;
        this.part = part;
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

    public PartsDto getPart() {
        return part;
    }

    public void setPart(PartsDto part) {
        this.part = part;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

}
