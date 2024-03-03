package com.gestrestau.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gestrestau.model.Entities.Dish;
import com.gestrestau.model.Entities.Ingredient;

public interface DishRepository extends CrudRepository<Dish,Long>{
    /*public Optional<Ingredient> findByName(String name); 
    public Iterable<Ingredient> findAll();*/
    
}
