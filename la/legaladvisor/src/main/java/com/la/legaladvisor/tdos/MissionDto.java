/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.tdos;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MissionDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String numCase;
    private String caseDate;
    private String sessionDate;
    private String gettingDate;
    private String type;
    private String notes;
    private int status;
    private JudgesDto judge;
    private List<PartsDto> parts;
    private List<SupportersDto> supporters;
    private String driveFolderId;
    private String allSessionDates;
    private double advance;
    private double proposedFee;
    private double finalFee;
    private CourtCirclesDto courtCircle;


    public MissionDto() {
    }

    public MissionDto(Long id) {
        this.id = id;
    }

    public MissionDto(Long id, String numCase, String caseDate, String sessionDate, String type, String notes, int status, JudgesDto judge, List<PartsDto> partsList, List<SupportersDto> supportersList) {
        this.id = id;
        this.numCase = numCase;
        this.caseDate = caseDate;
        this.sessionDate = sessionDate;
        this.type = type;
        this.notes = notes;
        this.status = status;
        this.judge = judge;
        this.parts = partsList;
        this.supporters = supportersList;
    }

    public JudgesDto getJudge() {
        return judge;
    }

    public void setJudge(JudgesDto judge) {
        this.judge = judge;
    }

    public String getDriveFolderId() {
        return driveFolderId;
    }

    public void setDriveFolderId(String driveFolderId) {
        this.driveFolderId = driveFolderId;
    }

    public String getGettingDate() {
        return gettingDate;
    }

    public void setGettingDate(String gettingDate) {
        this.gettingDate = gettingDate;
    }

    public String getAllSessionDates() {
        return allSessionDates;
    }

    public void setAllSessionDates(String allSessionDates) {
        this.allSessionDates = allSessionDates;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getProposedFee() {
        return proposedFee;
    }

    public void setProposedFee(double proposedFee) {
        this.proposedFee = proposedFee;
    }

    public double getFinalFee() {
        return finalFee;
    }

    public void setFinalFee(double finalFee) {
        this.finalFee = finalFee;
    }

    public CourtCirclesDto getCourtCircle() {
        return courtCircle;
    }

    public void setCourtCircle(CourtCirclesDto courtCircle) {
        this.courtCircle = courtCircle;
    }

    public void setCaseDate(String caseDate) {
        this.caseDate = caseDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getCaseDate() {
        return caseDate;
    }

    public String getSessionDate() {
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
        return judge;
    }

    public void setJudgeid(JudgesDto judge) {
        this.judge = judge;
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
