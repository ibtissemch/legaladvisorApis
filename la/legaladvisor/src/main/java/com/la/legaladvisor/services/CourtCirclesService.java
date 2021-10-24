/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.CourtCircles;
import com.la.legaladvisor.entities.Courts;
import com.la.legaladvisor.entities.Judges;
import com.la.legaladvisor.repositories.CourtCirclesRepository;
import com.la.legaladvisor.repositories.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Admin
 */
@Service
public class CourtCirclesService {

    @Autowired
    CourtCirclesRepository courtCirclesRepository;

    public List<CourtCircles> getAll() {
        return (List<CourtCircles>) courtCirclesRepository.findAll();
    }


    public CourtCircles getById(Long id) {
        return courtCirclesRepository.findById(id).orElse(null);
    }

    public CourtCircles createOrUpdate(CourtCircles courtCircles) {
        return courtCirclesRepository.save(courtCircles);
    }

    public void delete(Long id) {
        Optional<CourtCircles> courts = courtCirclesRepository.findById(id);
        courtCirclesRepository.delete(courts.get());
    }
}