package com.gestrestau.model.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data

public class Ingredient {
    //identifiant, nom, catégorie, quantité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    String name;
    String category;
    int quantity;
    String unit;
    String marque;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ingredient")
    private List<DishIngredient> dishIngredients;


    public Ingredient(){

    }
     public Ingredient(String name, String category, int quantity, String unit){
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
    }
    
    public Ingredient(String name, String category, int quantity, String unit, String marque){
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.unit = unit;
        this.marque = marque;
    }
}


