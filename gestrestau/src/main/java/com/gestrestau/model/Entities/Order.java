package com.gestrestau.model.Entities;

import java.util.ArrayList;
import java.util.List;

import com.gestrestau.model.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
// card --> menu
// ClientOrderMgmt --> gestion des commandes du client : Dish, Order, Menu
// AdminStockMgmt --> gestion du stock admin. : Food, Recipe
@Entity
@Data
@Table(name = "all_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ToString.Exclude // to avoid circular dependency leading to stack overflow on toString



    
    //@ManyToOne
    //OrderSheet orderSheet;

    @ManyToOne
    User user;

    @ManyToMany
    List<Dish> dishs = new ArrayList<Dish>();
    // commande est lié a des plats et au niveau des plats il y une entité d'association










    //int quantity;..On sait pas
    
    
    // on ne stock pas la quantité mais les opération d'ajout et de suppression
    //Appelez par exemple ModifStock(traçabilité)

    //boolean pour savoir si c'est une vrai commande ou une "fausse commande"
    boolean isOrder;

    public Order(){

    }

    public Order(List<Dish> dishs){
        this.dishs = dishs;
    }


}
