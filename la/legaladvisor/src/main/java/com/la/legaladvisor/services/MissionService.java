/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventAttendee;
import com.la.legaladvisor.entities.*;
import com.la.legaladvisor.repositories.MissionRepository;
import com.la.legaladvisor.tdos.MissionDto;
import com.la.legaladvisor.tdos.PartsDto;
import com.la.legaladvisor.tdos.SupportersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
@Service
public class MissionService {

    @Autowired
    MissionRepository missionsRepository;
    @Autowired
    CourtCirclesService courtCirclesService;
    @Autowired
    JudgesService judgesService;
    @Autowired
    SupportersService supportersService;
    @Autowired
    PartsService partsService;
    @Autowired
    GDriveService gDriveService;
    @Autowired
    GCalenderService gCalenderService;

    public List<Mission> getAll() {
        return (List<Mission>) missionsRepository.findAll();
    }

    public Mission createOrUpdate(String missionsDtostr, List<MultipartFile> multipartFileList) {
        Mission missions = new Mission();
        try { ObjectMapper objectMapper = new ObjectMapper();
        MissionDto missionsDto = objectMapper.readValue(missionsDtostr,MissionDto.class);

        // missions.setCaseDate(missionsDto.getCaseDate());
        missions.setNumCase(missionsDto.getNumCase());
        missions.setNotes(missionsDto.getNotes());
            // missions.setSessionDate(missionsDto.getSessionDate());
        missions.setStatus(0);
        missions.setType(missionsDto.getType());
        missions.setAdvance(missionsDto.getAdvance());
        missions.setProposedFee(missionsDto.getProposedFee());

        Judges judge = judgesService.getById(missionsDto.getJudgeid().getId());
        missions.setJudge(judge);

        CourtCircles courtCircles = courtCirclesService.getById(missionsDto.getCourtCircle().getId());
        missions.setCourtCircle(courtCircles);


        // create folder for All documents on

        String forlderId = gDriveService.createFolder(missionsDto.getNumCase());
        missions.setDriveFolderId(forlderId);
        missions = missionsRepository.save(missions);
        List<Supporters> supporters =new ArrayList<>();
        if(missionsDto.getSupporters() != null && !missionsDto.getSupporters().isEmpty())  {
            for(SupportersDto supportersDto: missionsDto.getSupporters()) {
                MultipartFile file = multipartFileList.stream().filter(multipartFile -> multipartFile.getName() == supportersDto.getName()).findFirst().orElse(null);
                if( file != null) {
                    Supporters supporter = new Supporters();
                    supporter.setName(supportersDto.getName());
                    supporter.setNotes(supportersDto.getNotes());
                    // supporter.setCreationDate(new Date());
                    // supporter.setLastUpdateDate(new Date());
                    supporter.setMission(missions);
                    supporter.setUrl(gDriveService.UploadFile(file,forlderId).getId());
                    supporters.add(supporter);
                }
            }
            missions.setSupporters(supporters);
        }
        // create call for All parts
         List<Parts> partsList = new ArrayList<>();
        List<Calls> callsList = new ArrayList<>();
        List<EventAttendee> attendees = new ArrayList<>();
        if(missionsDto.getParts() != null && !missionsDto.getParts().isEmpty())  {
            for(PartsDto partsDto : missionsDto.getParts()){
                Parts part = partsService.getById(partsDto.getId());
                String title = "RDV avec "+ part.getName() ;
                String description = " Num mission = " + missions.getNumCase();
                String location = "avenue de la liberty Tunis ";
                DateTime start = new DateTime ("2021-09-28T11:00:00+01:00"); // "2021-09-28T17:00:00-07:00"
                DateTime end = new DateTime ("2021-09-28T11:30:00+01:00"); // "2021-09-28T17:00:00-07:00"
                if(partsDto.getEmail() != null) {
                    EventAttendee eventAttendee = new EventAttendee();
                    eventAttendee.setEmail(partsDto.getEmail());
                    // add lawyers emails
                    attendees.add(eventAttendee);
                }
                gCalenderService.insert(title,location,description,start,end,attendees);
                partsList.add(part);
            }

        }
        } catch (Exception e) {

        }

        return null;
    }

    public void delete(Long id) {
        Optional<Mission> missions = missionsRepository.findById(id);
        missionsRepository.delete(missions.get());
    }
}