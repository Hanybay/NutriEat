package com.gestrestau.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gestrestau.model.Entities.Ingredient;

public interface IngredientsRepo extends CrudRepository<Ingredient,Long>{
    public Optional<Ingredient> findByName(String name); 
    public Iterable<Ingredient> findAll();
    
}
