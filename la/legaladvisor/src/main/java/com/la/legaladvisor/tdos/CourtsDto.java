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
import java.util.List;

/**
 *
 * @author Admin
 */

public class CourtsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String adress;
    private String gouvernance;
    private String tel;
    private List<CourtCirclesDto> courtCirclesDto;

    public CourtsDto() {
    }

    public CourtsDto(Long id) {
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

    public List<CourtCirclesDto> getCourtCirclesDto() {
        return courtCirclesDto;
    }

    public void setCourtCirclesDto(List<CourtCirclesDto> courtCirclesDto) {
        this.courtCirclesDto = courtCirclesDto;
    }
}
