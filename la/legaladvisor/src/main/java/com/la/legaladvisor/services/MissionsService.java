/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.Judges;
import com.la.legaladvisor.entities.Missions;
import com.la.legaladvisor.repositories.JudgesRepository;
import com.la.legaladvisor.repositories.MissionsRepository;
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
public class MissionsService {

    @Autowired
    MissionsRepository missionsRepository;

    public List<Missions> getAll() {
        return (List<Missions>) missionsRepository.findAll();
    }

    public Missions createOrUpdate(Missions mission) {
        return missionsRepository.save(mission);
    }

    public void delete(Long id) {
        Optional<Missions> missions = missionsRepository.findById(id);
        missionsRepository.delete(missions.get());
    }
}