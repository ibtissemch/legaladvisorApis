package com.la.legaladvisor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourtController {

    @GetMapping("/hello")
    public String getCourt() {
        return "hello";
    }
}
