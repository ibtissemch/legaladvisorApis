/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.Judges;
import com.la.legaladvisor.entities.Lawyers;
import com.la.legaladvisor.repositories.JudgesRepository;
import com.la.legaladvisor.repositories.LawyersRepository;
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
public class LawyersService {

    @Autowired
    LawyersRepository lawyersRepository;

    public List<Lawyers> getAll() {
        return (List<Lawyers>) lawyersRepository.findAll();
    }

    public Lawyers createOrUpdate(Lawyers lawyers) {
        return lawyersRepository.save(lawyers);
    }

    public void delete(Long id) {
        Optional<Lawyers> lawyers = lawyersRepository.findById(id);
        lawyersRepository.delete(lawyers.get());
    }
}