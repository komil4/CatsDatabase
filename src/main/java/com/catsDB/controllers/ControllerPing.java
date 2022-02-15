package com.catsDB.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPing {
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "Cats Service. Version 0.1";
    }
}
