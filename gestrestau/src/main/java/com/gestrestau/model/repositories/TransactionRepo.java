package com.gestrestau.model.repositories;

import com.gestrestau.model.Entities.Ingredient;
import com.gestrestau.model.Entities.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import java.util.Optional;
public interface TransactionRepo extends CrudRepository<Transaction,Long>{

    // Query that calculates available stock of each ingredient by summing the action using the list of available ingredients.
    @Query("SELECT t.ingredient, SUM(t.action) FROM Transaction t WHERE t.ingredient IN :ingredients GROUP BY t.ingredient")
    List<Object[]> calculateAvailableStock(@Param("ingredients") List<Ingredient> ingredients);
    
    @Query("SELECT COALESCE(SUM(t.action), 0) FROM Transaction t WHERE t.ingredient.id = :ingredientId")
    int getTotalQuantityForIngredient(@Param("ingredientId") Long ingredientId);
}