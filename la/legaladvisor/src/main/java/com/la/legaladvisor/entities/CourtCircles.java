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
@Table(name = "courtCircles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourtCircles.findAll", query = "SELECT c FROM CourtCircles c"),
    @NamedQuery(name = "CourtCircles.findById", query = "SELECT c FROM CourtCircles c WHERE c.id = :id"),
    @NamedQuery(name = "CourtCircles.findByName", query = "SELECT c FROM CourtCircles c WHERE c.name = :name"),
    @NamedQuery(name = "CourtCircles.findByAdress", query = "SELECT c FROM CourtCircles c WHERE c.adress = :adress"),
    @NamedQuery(name = "CourtCircles.findByTel", query = "SELECT c FROM CourtCircles c WHERE c.tel = :tel")})
public class CourtCircles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;
    @Column(name = "tel")
    private String tel;
    @JoinColumn(name = "Courtid", referencedColumnName = "id")
    @ManyToOne
    private Courts courtid;
    @OneToMany(mappedBy = "judgeid")
    private Collection<Missions> missionsCollection;

    public CourtCircles() {
    }

    public CourtCircles(Long id) {
        this.id = id;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Courts getCourtid() {
        return courtid;
    }

    public void setCourtid(Courts courtid) {
        this.courtid = courtid;
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
        if (!(object instanceof CourtCircles)) {
            return false;
        }
        CourtCircles other = (CourtCircles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Collection<Missions> getMissionsCollection() {
        return missionsCollection;
    }

    public void setMissionsCollection(Collection<Missions> missionsCollection) {
        this.missionsCollection = missionsCollection;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.CourtCircles[ id=" + id + " ]";
    }
    
}
