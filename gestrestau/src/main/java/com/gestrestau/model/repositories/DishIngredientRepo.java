package com.gestrestau.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gestrestau.model.Entities.DishIngredient;

public interface DishIngredientRepo extends CrudRepository<DishIngredient,Long>{
    
}
