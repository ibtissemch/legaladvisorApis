/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.CourtCircles;
import com.la.legaladvisor.entities.Parts;
import com.la.legaladvisor.repositories.MissionRepository;
import com.la.legaladvisor.repositories.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
@Service
public class PartsService {

    @Autowired
    PartsRepository partsRepository;

    public List<Parts> getAll() {
        return (List<Parts>) partsRepository.findAll();
    }

    public Parts createOrUpdate(Parts parts) {
        return partsRepository.save(parts);
    }

    public Parts getById(Long id) {
        return partsRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        Optional<Parts> parts = partsRepository.findById(id);
        partsRepository.delete(parts.get());
    }
}