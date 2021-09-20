/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.tdos;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MissionsDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String numCase;
    private LocalDateTime caseDate;
    private LocalDateTime sessionDate;
    private String type;
    private String notes;
    private int status;
    private JudgesDto judgeid;
    private List<PartsDto> parts;
    private List<SupportersDto> supporters;

    public MissionsDto() {
    }

    public MissionsDto(Long id) {
        this.id = id;
    }

    public MissionsDto(Long id, String numCase, LocalDateTime caseDate, LocalDateTime sessionDate, String type, String notes, int status, JudgesDto judgeid, List<PartsDto> partsList, List<SupportersDto> supportersList) {
        this.id = id;
        this.numCase = numCase;
        this.caseDate = caseDate;
        this.sessionDate = sessionDate;
        this.type = type;
        this.notes = notes;
        this.status = status;
        this.judgeid = judgeid;
        this.parts = partsList;
        this.supporters = supportersList;
    }

    public void setCaseDate(LocalDateTime caseDate) {
        this.caseDate = caseDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public LocalDateTime getCaseDate() {
        return caseDate;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumCase() {
        return numCase;
    }

    public void setNumCase(String numCase) {
        this.numCase = numCase;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JudgesDto getJudgeid() {
        return judgeid;
    }

    public void setJudgeid(JudgesDto judgeid) {
        this.judgeid = judgeid;
    }

    public List<PartsDto> getParts() {
        return parts;
    }

    public void setParts(List<PartsDto> parts) {
        this.parts = parts;
    }

    public List<SupportersDto> getSupporters() {
        return supporters;
    }

    public void setSupporters(List<SupportersDto> supporters) {
        this.supporters = supporters;
    }
}
