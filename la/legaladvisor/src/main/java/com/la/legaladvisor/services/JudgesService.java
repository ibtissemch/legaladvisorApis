/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.CourtCircles;
import com.la.legaladvisor.entities.Judges;
import com.la.legaladvisor.repositories.CourtCirclesRepository;
import com.la.legaladvisor.repositories.JudgesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Admin
 */
@Service
public class JudgesService {

    @Autowired
    JudgesRepository judgesRepository;

    public List<Judges> getAll() {
        return (List<Judges>) judgesRepository.findAll();
    }

    public Judges createOrUpdate(Judges judges) {
        return judgesRepository.save(judges);
    }

    public void delete(Long id) {
        Optional<Judges> judges = judgesRepository.findById(id);
        judgesRepository.delete(judges.get());
    }
}