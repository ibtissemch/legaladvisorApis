/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Mission;
import com.la.legaladvisor.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Admin
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/missions")
public class MissionController {

    @Autowired
    MissionService missionsService;

    @GetMapping()
    List<Mission> getCalls() {
        return missionsService.getAll();
    }

    @PostMapping()
    Mission createOrUpdateCalls(@RequestParam("mission") String missions, @RequestParam(value = "files",required = false) List<MultipartFile> files) {
        return missionsService.createOrUpdate(missions,files);
    }

    @DeleteMapping()
    void delete(long id) {
        missionsService.delete(id);
    }
}