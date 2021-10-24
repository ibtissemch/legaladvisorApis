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
    private boolean willPay;
    private Long advance;
    private Long totalfee;
    private String registreCommercial;
    private String tel;
    private String email;
    private List<LawyersDto> lawyers;
    private List<CallsDto> calls;
    private MissionDto mission;
    private boolean lawyerContact;

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

    public boolean isWillPay() {
        return willPay;
    }

    public void setWillPay(boolean willPay) {
        this.willPay = willPay;
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

    public MissionDto getMission() {
        return mission;
    }

    public void setMission(MissionDto mission) {
        this.mission = mission;
    }

    public boolean isLawyerContact() {
        return lawyerContact;
    }

    public void setLawyerContact(boolean lawyerContact) {
        this.lawyerContact = lawyerContact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRegistreCommercial() {
        return registreCommercial;
    }

    public void setRegistreCommercial(String registreCommercial) {
        this.registreCommercial = registreCommercial;
    }
}
