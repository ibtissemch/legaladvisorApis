/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "parts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parts.findAll", query = "SELECT p FROM Parts p"),
    @NamedQuery(name = "Parts.findById", query = "SELECT p FROM Parts p WHERE p.id = :id"),
    @NamedQuery(name = "Parts.findByPartType", query = "SELECT p FROM Parts p WHERE p.partType = :partType"),
    @NamedQuery(name = "Parts.findByName", query = "SELECT p FROM Parts p WHERE p.name = :name"),
    @NamedQuery(name = "Parts.findByAdresse", query = "SELECT p FROM Parts p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Parts.findByTel", query = "SELECT p FROM Parts p WHERE p.tel = :tel"),
    @NamedQuery(name = "Parts.findByEmail", query = "SELECT p FROM Parts p WHERE p.email = :email")})
public class Parts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "partType")
    private String partType;
    @Column(name = "registreCommercial")
    private String registreCommercial;
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

    public Parts(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}
