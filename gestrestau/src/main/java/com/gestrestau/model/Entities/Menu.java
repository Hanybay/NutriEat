package com.gestrestau.model.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data

public class Menu {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    String name;

    @ManyToMany
    private List<Dish> dishs = new ArrayList<Dish>();

    public Menu(){


    }
    public Menu(List<Dish> dishs){
        this.dishs = dishs;
    }

}
