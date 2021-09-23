/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "calls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calls.findAll", query = "SELECT c FROM Calls c"),
    @NamedQuery(name = "Calls.findById", query = "SELECT c FROM Calls c WHERE c.id = :id"),
    @NamedQuery(name = "Calls.findByName", query = "SELECT c FROM Calls c WHERE c.name = :name"),
    @NamedQuery(name = "Calls.findByUrl", query = "SELECT c FROM Calls c WHERE c.url = :url"),
    @NamedQuery(name = "Calls.findByCreationDate", query = "SELECT c FROM Calls c WHERE c.creationDate = :creationDate"),
    @NamedQuery(name = "Calls.findBySentDate", query = "SELECT c FROM Calls c WHERE c.sentDate = :sentDate"),
    @NamedQuery(name = "Calls.findByState", query = "SELECT c FROM Calls c WHERE c.state = :state"),
    @NamedQuery(name = "Calls.findByDuration", query = "SELECT c FROM Calls c WHERE c.duration = :duration"),
    @NamedQuery(name = "Calls.findByMeetingDate", query = "SELECT c FROM Calls c WHERE c.meetingDate = :meetingDate")})
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "sentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;
    @Basic(optional = false)
    @Column(name = "state")
    private int state;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "meetingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date meetingDate;
    @Basic(optional = false)
    @Column(name = "with_inspection")
    private boolean withInspection;
    @Basic(optional = false)
    @Column(name = "inspection_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inspectionDate;
    @JoinColumn(name = "partid", referencedColumnName = "id")
    @ManyToOne
    private Parts partid;

    public Calls() {
    }

    public Calls(Long id) {
        this.id = id;
    }

    public Calls(Long id, Date creationDate, Date sentDate, int state, int duration, Date meetingDate) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
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

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Parts getPartid() {
        return partid;
    }

    public void setPartid(Parts partid) {
        this.partid = partid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
}