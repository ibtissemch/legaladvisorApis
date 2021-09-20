/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Parts;
import com.la.legaladvisor.entities.Supporters;
import com.la.legaladvisor.services.PartsService;
import com.la.legaladvisor.services.SupportersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/supporters")
public class SupportersController {

        @Autowired
        SupportersService supportersService;

        @GetMapping()
        List<Supporters> getCalls() {
            return supportersService.getAll();
        }

        @PostMapping()
        Supporters createOrUpdateCalls(Supporters supporter) {
            return supportersService.createOrUpdate(supporter);
        }

        @DeleteMapping()
        void delete(long id) {
            supportersService.delete(id);
        }
    }