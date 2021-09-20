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
@Table(name = "supporters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supporters.findAll", query = "SELECT s FROM Supporters s"),
    @NamedQuery(name = "Supporters.findById", query = "SELECT s FROM Supporters s WHERE s.id = :id"),
    @NamedQuery(name = "Supporters.findByName", query = "SELECT s FROM Supporters s WHERE s.name = :name"),
    @NamedQuery(name = "Supporters.findByNotes", query = "SELECT s FROM Supporters s WHERE s.notes = :notes"),
    @NamedQuery(name = "Supporters.findByType", query = "SELECT s FROM Supporters s WHERE s.type = :type"),
    @NamedQuery(name = "Supporters.findByCreationDate", query = "SELECT s FROM Supporters s WHERE s.creationDate = :creationDate"),
    @NamedQuery(name = "Supporters.findByLastUpdateDate", query = "SELECT s FROM Supporters s WHERE s.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "Supporters.findByUrl", query = "SELECT s FROM Supporters s WHERE s.url = :url")})
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "lastUpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "missionid", referencedColumnName = "id")
    @ManyToOne
    private Missions missionid;

    public Supporters() {
    }

    public Supporters(Long id) {
        this.id = id;
    }

    public Supporters(Long id, Date creationDate, Date lastUpdateDate) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Missions getMissionid() {
        return missionid;
    }

    public void setMissionid(Missions missionid) {
        this.missionid = missionid;
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
        if (!(object instanceof Supporters)) {
            return false;
        }
        Supporters other = (Supporters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Supporters[ id=" + id + " ]";
    }
    
}
