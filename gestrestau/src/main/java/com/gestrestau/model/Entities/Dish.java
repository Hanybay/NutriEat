package com.gestrestau.model.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data

public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    
    String description;


    //@OneToMany
    //List<Ingredient> ingredients = new ArrayList<Ingredient>() ;
    @ToString.Exclude
    @OneToMany(mappedBy = "dish")
    private List<DishIngredient> dishIngredients;


    
    float price;


    public Dish(){

    }

    public Dish(String name, float price){
        this.name=name;
        this.price=price;

    }

    public Dish(String name, String description, float price){
        this.name=name;
        this.price=price;
        this.description = description;
    }

}
