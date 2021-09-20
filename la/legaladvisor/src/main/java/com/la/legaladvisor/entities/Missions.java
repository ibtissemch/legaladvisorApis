/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "missions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Missions.findAll", query = "SELECT m FROM Missions m"),
    @NamedQuery(name = "Missions.findById", query = "SELECT m FROM Missions m WHERE m.id = :id"),
    @NamedQuery(name = "Missions.findByNumCase", query = "SELECT m FROM Missions m WHERE m.numCase = :numCase"),
    @NamedQuery(name = "Missions.findByCaseDate", query = "SELECT m FROM Missions m WHERE m.caseDate = :caseDate"),
    @NamedQuery(name = "Missions.findBySessionDate", query = "SELECT m FROM Missions m WHERE m.sessionDate = :sessionDate"),
    @NamedQuery(name = "Missions.findByType", query = "SELECT m FROM Missions m WHERE m.type = :type"),
    @NamedQuery(name = "Missions.findByNotes", query = "SELECT m FROM Missions m WHERE m.notes = :notes"),
    @NamedQuery(name = "Missions.findByStatus", query = "SELECT m FROM Missions m WHERE m.status = :status")})
public class Missions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "numCase")
    private String numCase;
    @Basic(optional = false)
    @Column(name = "caseDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date caseDate;
    @Basic(optional = false)
    @Column(name = "sessionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sessionDate;
    @Column(name = "type")
    private String type;
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "judgeid", referencedColumnName = "id")
    @ManyToOne
    private Judges judgeid;
    @JoinColumn(name = "courtCircleid", referencedColumnName = "id")
    @ManyToOne
    private CourtCircles courtCircleid;
    @OneToMany(mappedBy = "missionid")
    private Collection<Parts> partsCollection;
    @OneToMany(mappedBy = "missionid")
    private Collection<Supporters> supportersCollection;

    public Missions() {
    }

    public Missions(Long id) {
        this.id = id;
    }

    public Missions(Long id, Date caseDate, Date sessionDate, int status) {
        this.id = id;
        this.caseDate = caseDate;
        this.sessionDate = sessionDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumCase() {
        return numCase;
    }

    public void setNumCase(String numCase) {
        this.numCase = numCase;
    }

    public Date getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(Date caseDate) {
        this.caseDate = caseDate;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Judges getJudgeid() {
        return judgeid;
    }

    public void setJudgeid(Judges judgeid) {
        this.judgeid = judgeid;
    }

    @XmlTransient
    public Collection<Parts> getPartsCollection() {
        return partsCollection;
    }

    public void setPartsCollection(Collection<Parts> partsCollection) {
        this.partsCollection = partsCollection;
    }

    @XmlTransient
    public Collection<Supporters> getSupportersCollection() {
        return supportersCollection;
    }

    public void setSupportersCollection(Collection<Supporters> supportersCollection) {
        this.supportersCollection = supportersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Missions)) {
            return false;
        }
        Missions other = (Missions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public CourtCircles getCourtCircleid() {
        return courtCircleid;
    }

    public void setCourtCircleid(CourtCircles courtCircleid) {
        this.courtCircleid = courtCircleid;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Missions[ id=" + id + " ]";
    }
    
}
