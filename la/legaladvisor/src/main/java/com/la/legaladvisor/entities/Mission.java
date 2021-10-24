/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.la.legaladvisor.convertors.LocalDateTimeAttributeConverter;
import com.la.legaladvisor.convertors.LocalDateTimeSerializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "missions")
public class Mission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "drive_folder_id")
    private String driveFolderId;
    @Column(name = "numCase")
    private String numCase;
    @Basic(optional = false)
    @Column(name = "caseDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime caseDate;
    @Basic(optional = false)
    @Column(name = "sessionDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private  LocalDateTime sessionDate;
    @Column(name = "all_session_dates")
    private String allSessionDates;
    @Column(name = "creationDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private  LocalDateTime creationDate;
    @Column(name = "gettingDate")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private  LocalDateTime gettingDate;
    @Column(name = "type")
    private String type;
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "advance")
    private double advance;
    @Basic(optional = false)
    @Column(name = "proposed_fee")
    private double proposedFee;
    @Basic(optional = false)
    @Column(name = "final_fee")
    private double finalFee;
    @JoinColumn(name = "judge", referencedColumnName = "id")
    @ManyToOne
    private Judges judge;
    @JoinColumn(name = "courtCircle", referencedColumnName = "id")
    @ManyToOne
    private CourtCircles courtCircle;
    @OneToMany(mappedBy = "mission")
    private List<Parts> parts;
    @OneToMany(mappedBy = "mission")
    private List<Supporters> supporters;

    public Mission() {
    }

    public Mission(Long id) {
        this.id = id;
    }

    public Mission(Long id, int status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriveFolderId() {
        return driveFolderId;
    }

    public void setDriveFolderId(String driveFolderId) {
        this.driveFolderId = driveFolderId;
    }

    public String getNumCase() {
        return numCase;
    }

    public void setNumCase(String numCase) {
        this.numCase = numCase;
    }

    public LocalDateTime getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(LocalDateTime caseDate) {
        this.caseDate = caseDate;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
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

    public String getAllSessionDates() {
        return allSessionDates;
    }

    public void setAllSessionDates(String allSessionDates) {
        this.allSessionDates = allSessionDates;
    }

    public Judges getJudge() {
        return judge;
    }

    public void setJudge(Judges judge) {
        this.judge = judge;
    }

    public CourtCircles getCourtCircle() {
        return courtCircle;
    }

    public void setCourtCircle(CourtCircles courtCircle) {
        this.courtCircle = courtCircle;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public List<Supporters> getSupporters() {
        return supporters;
    }

    public void setSupporters(List<Supporters> supporters) {
        this.supporters = supporters;
    }

    public LocalDateTime getGettingDate() {
        return gettingDate;
    }

    public void setGettingDate(LocalDateTime gettingDate) {
        this.gettingDate = gettingDate;
    }
}
