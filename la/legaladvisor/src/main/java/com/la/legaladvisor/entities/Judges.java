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
@Table(name = "judges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Judges.findAll", query = "SELECT j FROM Judges j"),
    @NamedQuery(name = "Judges.findById", query = "SELECT j FROM Judges j WHERE j.id = :id"),
    @NamedQuery(name = "Judges.findByFirstName", query = "SELECT j FROM Judges j WHERE j.firstName = :firstName"),
    @NamedQuery(name = "Judges.findByLastName", query = "SELECT j FROM Judges j WHERE j.lastName = :lastName"),
    @NamedQuery(name = "Judges.findByAdresse", query = "SELECT j FROM Judges j WHERE j.adresse = :adresse"),
    @NamedQuery(name = "Judges.findByEmail", query = "SELECT j FROM Judges j WHERE j.email = :email"),
    @NamedQuery(name = "Judges.findByTel", query = "SELECT j FROM Judges j WHERE j.tel = :tel"),
    @NamedQuery(name = "Judges.findByPoste", query = "SELECT j FROM Judges j WHERE j.poste = :poste")})
public class Judges implements Serializable {

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
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "email")
    private String email;
    @Column(name = "tel")
    private String tel;
    @Column(name = "poste")
    private String poste;
    @OneToMany(mappedBy = "judgeid")
    private Collection<Missions> missionsCollection;

    public Judges() {
    }

    public Judges(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @XmlTransient
    public Collection<Missions> getMissionsCollection() {
        return missionsCollection;
    }

    public void setMissionsCollection(Collection<Missions> missionsCollection) {
        this.missionsCollection = missionsCollection;
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
        if (!(object instanceof Judges)) {
            return false;
        }
        Judges other = (Judges) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Judges[ id=" + id + " ]";
    }
    
}
