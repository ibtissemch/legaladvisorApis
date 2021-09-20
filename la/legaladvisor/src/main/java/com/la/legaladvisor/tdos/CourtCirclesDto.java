/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.tdos;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CourtCirclesDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String adress;
    private String tel;
    private CourtsDto courtid;
    private List<JudgesDto> partjudgesDto;

    public CourtCirclesDto() {
    }

    public CourtCirclesDto(Long id) {
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

    public CourtsDto getCourtid() {
        return courtid;
    }

    public void setCourtid(CourtsDto courtid) {
        this.courtid = courtid;
    }

    public List<JudgesDto> getPartjudgesDto() {
        return partjudgesDto;
    }

    public void setPartjudgesDto(List<JudgesDto> partjudgesDto) {
        this.partjudgesDto = partjudgesDto;
    }
}
