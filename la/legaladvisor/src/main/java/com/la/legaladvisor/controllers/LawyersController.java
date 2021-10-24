/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Judges;
import com.la.legaladvisor.entities.Lawyers;
import com.la.legaladvisor.services.JudgesService;
import com.la.legaladvisor.services.LawyersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/lawyers")
@CrossOrigin("*")
public class LawyersController {

        @Autowired
        LawyersService lawyersService;

        @GetMapping()
        List<Lawyers> getCalls() {
            return lawyersService.getAll();
        }

        @PostMapping()
        Lawyers createOrUpdateCalls(Lawyers lawyers) {
            return lawyersService.createOrUpdate(lawyers);
        }

        @DeleteMapping()
        void delete(long id) {
            lawyersService.delete(id);
        }
    }