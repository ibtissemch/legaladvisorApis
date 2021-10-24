/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.tdos;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */

public class JudgesDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private String adresse;
    private String email;
    private String tel;
    private String poste;
    private List<MissionDto> missionsDtos;
    private CourtCirclesDto courtCircleid;

    public JudgesDto() {
    }

    public JudgesDto(Long id) {
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

    public List<MissionDto> getMissionDtos() {
        return missionsDtos;
    }

    public void setMissionDtos(List<MissionDto> missionsDtos) {
        this.missionsDtos = missionsDtos;
    }

    public CourtCirclesDto getCourtCircleid() {
        return courtCircleid;
    }

    public void setCourtCircleid(CourtCirclesDto courtCircleid) {
        this.courtCircleid = courtCircleid;
    }


}
