/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Mission;
import com.la.legaladvisor.entities.Parts;
import com.la.legaladvisor.services.MissionService;
import com.la.legaladvisor.services.PartsService;
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
@RequestMapping("/api/parts")
public class PartsController {

    @Autowired
    PartsService partsService;

    @GetMapping()
    List<Parts> getCalls() {
        return partsService.getAll();
    }

    @PostMapping()
    Parts createOrUpdateCalls(Parts part) {
        return partsService.createOrUpdate(part);
    }

    @DeleteMapping()
    void delete(long id) {
        partsService.delete(id);
    }
}