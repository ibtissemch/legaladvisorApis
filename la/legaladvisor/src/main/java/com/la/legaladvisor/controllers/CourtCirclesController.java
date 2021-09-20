/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Calls;
import com.la.legaladvisor.entities.CourtCircles;
import com.la.legaladvisor.services.CallsServices;
import com.la.legaladvisor.services.CourtCirclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author Admin
 */
@RestController
@RequestMapping("/api/courtcircles")
public class CourtCirclesController {

    @Autowired
    CourtCirclesService courtCirclesService;

    @GetMapping()
    List<CourtCircles> getCalls() {
        return courtCirclesService.getAll();
    }

    @PostMapping()
    CourtCircles createOrUpdateCalls(CourtCircles courtCircles) {
        return courtCirclesService.createOrUpdate(courtCircles);
    }

    @DeleteMapping()
    void delete(long id) {
        courtCirclesService.delete(id);
    }

}