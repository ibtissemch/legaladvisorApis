/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.tdos;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PartsDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String partType;
    private String name;
    private String adresse;
    private String tel;
    private String email;
    private List<LawyersDto> lawyers;
    private List<CallsDto> calls;
    private MissionsDto mission;

    public PartsDto() {
    }

    public PartsDto(Long id) {
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

    public List<LawyersDto> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<LawyersDto> lawyers) {
        this.lawyers = lawyers;
    }

    public List<CallsDto> getCalls() {
        return calls;
    }

    public void setCalls(List<CallsDto> calls) {
        this.calls = calls;
    }

    public MissionsDto getMission() {
        return mission;
    }

    public void setMission(MissionsDto mission) {
        this.mission = mission;
    }
}
