/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Judges;
import com.la.legaladvisor.services.CourtCirclesService;
import com.la.legaladvisor.services.JudgesService;
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
@RequestMapping("/api/judges")
@CrossOrigin("*")
public class JudgesController {

    @Autowired
    JudgesService judgesService;

    @GetMapping()
    List<Judges> getCalls() {
        return judgesService.getAll();
    }

    @PostMapping()
    Judges createOrUpdateCalls(Judges judges) {
        return judgesService.createOrUpdate(judges);
    }

    @DeleteMapping()
    void delete(long id) {
        judgesService.delete(id);
    }
}