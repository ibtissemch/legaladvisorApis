package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.Courts;
import com.la.legaladvisor.repositories.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    @Autowired
    CourtRepository courtRepository;

    public List<Courts> getAll(){
        return (List<Courts>) courtRepository.findAll();
    }

    public Courts createOrUpdateCourt(Courts court) {
        return  courtRepository.save(court);
    }

    public void deleteCourt(Long id) {
        Optional<Courts> courts = courtRepository.findById(id);
        courtRepository.delete(courts.get());
    }
}
