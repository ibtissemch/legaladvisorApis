/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.la.legaladvisor.controllers;

import com.la.legaladvisor.entities.Calls;
import com.la.legaladvisor.services.CallsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/call")
public class CallsController {

    @Autowired
    CallsServices callsServices;

    @GetMapping()
    List<Calls> getCalls() {
        return callsServices.getAllCalls();
    }

    @PostMapping()
    Calls createOrUpdateCalls(Calls call) {
        return callsServices.createOrUpadte(call);
    }

    @DeleteMapping()
    void delete(long id) {
         callsServices.deleteCall(id);
    }

}
