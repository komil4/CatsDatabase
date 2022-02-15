package com.catsDB.controllers;

import com.catsDB.models.Cat;
import com.catsDB.services.CatStatisticServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerCatsList {
    @RequestMapping(value = "/cats", method = RequestMethod.GET)
    public List<Cat> ping(@RequestParam(required = false) String attribute, @RequestParam(required = false) String order) {
        CatStatisticServiceImpl catService = new CatStatisticServiceImpl();
        return catService.getAll();
    }

}
