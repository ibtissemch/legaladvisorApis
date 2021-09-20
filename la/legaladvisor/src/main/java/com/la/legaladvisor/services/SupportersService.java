/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.Parts;
import com.la.legaladvisor.entities.Supporters;
import com.la.legaladvisor.repositories.PartsRepository;
import com.la.legaladvisor.repositories.SupportersRepository;
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

public class SupportersService {

    @Autowired
    SupportersRepository supportersRepository;

    public List<Supporters> getAll() {
        return (List<Supporters>) supportersRepository.findAll();
    }

    public Supporters createOrUpdate(Supporters supporter) {
        return supportersRepository.save(supporter);
    }

    public void delete(Long id) {
        Optional<Supporters> supporter = supportersRepository.findById(id);
        supportersRepository.delete(supporter.get());
    }
}