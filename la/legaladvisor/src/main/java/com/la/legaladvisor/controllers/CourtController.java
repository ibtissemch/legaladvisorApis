package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Courts;
import com.la.legaladvisor.services.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/court")
@CrossOrigin("*")
public class CourtController {

    @Autowired
    CourtService courtService;

    @GetMapping()
    public List<Courts> getCourts() {
        return courtService.getAll();
    }

    @PostMapping()
    public Courts createOrUpdate(Courts courts) {
        return courtService.createOrUpdateCourt(courts);
    }

    @DeleteMapping()
    public void delete(Long id) {
        courtService.deleteCourt(id);
    }
}
