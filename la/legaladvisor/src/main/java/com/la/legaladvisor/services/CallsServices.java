/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.services;

import com.la.legaladvisor.entities.Calls;
import com.la.legaladvisor.repositories.CallsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Admin
 */
@Service
public class CallsServices {

    @Autowired
    CallsRepository callsRepository;

    public List<Calls> getAllCalls() {
        try {
            return (List) callsRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.toString());
            //throw  new Exception();
            return  null;
        }
    }

    Calls CreateOrUpdateCalls(Calls call) {
        return callsRepository.save(call);
    }

    Optional<Calls> getCallsById(Long id) {
        return callsRepository.findById(id);
    }

    void DeleteCalls(Long id) {
        Optional<Calls> calls = getCallsById(id);
        callsRepository.delete(calls.get());
    }

    public Calls createOrUpadte(Calls call) {
        return callsRepository.save(call);
    }

    public void deleteCall(long id) {
        Optional<Calls> calltoDelete = callsRepository.findById(id);

    }
}
