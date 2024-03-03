package com.gestrestau.model.Entities;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;//ID de la transaction
    
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    
    int action;

    Date date;
    //ID ingrédient, action, date

    public Transaction(){
        
    }
    public Transaction(Ingredient ingredient, int action, Date date){
        this.ingredient = ingredient;
        this.action = action;
        this.date = date;
    }
    
    public Transaction(Ingredient ingredient, int action){
        this.ingredient = ingredient;
        this.action = action;

    }
}
