package com.catsDB.controllers;

import com.catsDB.enums.OrderType;
import com.catsDB.models.Cat;
import com.catsDB.repository.CatsRepository;
import com.catsDB.services.CatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerCatsList {
    @Autowired
    protected CatsRepository catsRepository;

    @RequestMapping(value = "/cats", method = RequestMethod.GET)
    public List<Cat> cats(@RequestParam(required = false) String attribute, @RequestParam(required = false) OrderType order,
    @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        CatServiceImpl catService = new CatServiceImpl(catsRepository);
        catService.setAttribute(attribute);
        catService.setOrder(order);
        catService.setOffset(offset == null ? 0 : offset);
        catService.setLimit(limit == null ? 0 : limit);
        return catService.getAll();
    }

}
