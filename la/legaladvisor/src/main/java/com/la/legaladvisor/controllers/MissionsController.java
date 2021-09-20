/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Judges;
import com.la.legaladvisor.entities.Missions;
import com.la.legaladvisor.services.JudgesService;
import com.la.legaladvisor.services.MissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Admin
 */
@RestController
@RequestMapping("/api/missions")
public class MissionsController {

    @Autowired
    MissionsService missionsService;

    @GetMapping()
    List<Missions> getCalls() {
        return missionsService.getAll();
    }

    @PostMapping()
    Missions createOrUpdateCalls(Missions missions) {
        return missionsService.createOrUpdate(missions);
    }

    @DeleteMapping()
    void delete(long id) {
        missionsService.delete(id);
    }
}