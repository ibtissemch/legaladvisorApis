/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
    @Column(name = "willpay")
    private boolean willPay;
    @Column(name = "advance")
    private Long advance;
    @Column(name = "totalfee")
    private Long totalfee;
    @Column(name = "lawyerContact")
    private boolean lawyerContact;
    @ManyToMany(mappedBy = "parts")
    private List<Lawyers> lawyers;
    @OneToMany(mappedBy = "part")
    private List<Calls> calls;
    @JoinColumn(name = "mission", referencedColumnName = "id")
    @ManyToOne
    private Mission mission;

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

    public String getRegistreCommercial() {
        return registreCommercial;
    }

    public void setRegistreCommercial(String registreCommercial) {
        this.registreCommercial = registreCommercial;
    }

    public boolean isWillPay() {
        return willPay;
    }

    public void setWillPay(boolean willPay) {
        this.willPay = willPay;
    }

    public boolean isLawyerContact() {
        return lawyerContact;
    }

    public void setLawyerContact(boolean lawyerContact) {
        this.lawyerContact = lawyerContact;
    }

    public List<Lawyers> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyers> lawyers) {
        this.lawyers = lawyers;
    }

    public List<Calls> getCalls() {
        return calls;
    }

    public void setCalls(List<Calls> calls) {
        this.calls = calls;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Long getAdvance() {
        return advance;
    }

    public void setAdvance(Long advance) {
        this.advance = advance;
    }

    public Long getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(Long totalfee) {
        this.totalfee = totalfee;
    }
}
