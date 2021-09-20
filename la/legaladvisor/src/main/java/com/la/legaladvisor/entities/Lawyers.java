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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "lawyers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lawyers.findAll", query = "SELECT l FROM Lawyers l"),
    @NamedQuery(name = "Lawyers.findById", query = "SELECT l FROM Lawyers l WHERE l.id = :id"),
    @NamedQuery(name = "Lawyers.findByFirstName", query = "SELECT l FROM Lawyers l WHERE l.firstName = :firstName"),
    @NamedQuery(name = "Lawyers.findByLastName", query = "SELECT l FROM Lawyers l WHERE l.lastName = :lastName"),
    @NamedQuery(name = "Lawyers.findByAdresse", query = "SELECT l FROM Lawyers l WHERE l.adresse = :adresse"),
    @NamedQuery(name = "Lawyers.findByTel", query = "SELECT l FROM Lawyers l WHERE l.tel = :tel")})
public class Lawyers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "tel")
    private String tel;
    @JoinTable(name = "LawyerPart", joinColumns = {
        @JoinColumn(name = "lawyersid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "partsid", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Parts> partsCollection;

    public Lawyers() {
    }

    public Lawyers(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @XmlTransient
    public Collection<Parts> getPartsCollection() {
        return partsCollection;
    }

    public void setPartsCollection(Collection<Parts> partsCollection) {
        this.partsCollection = partsCollection;
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
        if (!(object instanceof Lawyers)) {
            return false;
        }
        Lawyers other = (Lawyers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Lawyers[ id=" + id + " ]";
    }
    
}
