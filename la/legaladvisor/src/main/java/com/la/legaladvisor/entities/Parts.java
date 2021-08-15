/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "parts")
public class Parts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "partType")
    private String partType;
    @Column(name = "name")
    private String name;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "tel")
    private String tel;
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "partsCollection")
    private Collection<Lawyers> lawyersCollection;
    @OneToMany(mappedBy = "partid")
    private Collection<Calls> callsCollection;
    @JoinColumn(name = "missionid", referencedColumnName = "id")
    @ManyToOne
    private Missions missionid;

    public Parts() {
    }

    public Parts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Lawyers> getLawyersCollection() {
        return lawyersCollection;
    }

    public void setLawyersCollection(Collection<Lawyers> lawyersCollection) {
        this.lawyersCollection = lawyersCollection;
    }

    @XmlTransient
    public Collection<Calls> getCallsCollection() {
        return callsCollection;
    }

    public void setCallsCollection(Collection<Calls> callsCollection) {
        this.callsCollection = callsCollection;
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
        if (!(object instanceof Parts)) {
            return false;
        }
        Parts other = (Parts) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Parts[ id=" + id + " ]";
    }
    
}
