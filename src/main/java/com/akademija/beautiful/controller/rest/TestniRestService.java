package com.akademija.beautiful.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:8081/api/test GET
 */
@RestController
@RequestMapping(("/api"))
public class TestniRestService {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(){
        return "Test uspješan";
    }
}
