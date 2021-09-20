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
@Table(name = "courts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courts.findAll", query = "SELECT c FROM Courts c"),
    @NamedQuery(name = "Courts.findById", query = "SELECT c FROM Courts c WHERE c.id = :id"),
    @NamedQuery(name = "Courts.findByName", query = "SELECT c FROM Courts c WHERE c.name = :name"),
    @NamedQuery(name = "Courts.findByAdress", query = "SELECT c FROM Courts c WHERE c.adress = :adress"),
    @NamedQuery(name = "Courts.findByGouvernance", query = "SELECT c FROM Courts c WHERE c.gouvernance = :gouvernance"),
    @NamedQuery(name = "Courts.findByTel", query = "SELECT c FROM Courts c WHERE c.tel = :tel")})
public class Courts implements Serializable {

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
    @Column(name = "gouvernance")
    private String gouvernance;
    @Column(name = "tel")
    private String tel;
    @OneToMany(mappedBy = "courtid")
    private Collection<CourtCircles> courtCirclesCollection;

    public Courts() {
    }

    public Courts(Long id) {
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

    public String getGouvernance() {
        return gouvernance;
    }

    public void setGouvernance(String gouvernance) {
        this.gouvernance = gouvernance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @XmlTransient
    public Collection<CourtCircles> getCourtCirclesCollection() {
        return courtCirclesCollection;
    }

    public void setCourtCirclesCollection(Collection<CourtCircles> courtCirclesCollection) {
        this.courtCirclesCollection = courtCirclesCollection;
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
        if (!(object instanceof Courts)) {
            return false;
        }
        Courts other = (Courts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Courts[ id=" + id + " ]";
    }
    
}
