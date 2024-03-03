package com.gestrestau.controller;


import org.springframework.web.bind.annotation.RestController;

import com.gestrestau.model.Entities.Dish;
import com.gestrestau.model.repositories.DishRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/dishs")
public class DishController {
    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/all")
    public Iterable<Dish> getAllDish() {
        return dishRepository.findAll();
    }
    
}
