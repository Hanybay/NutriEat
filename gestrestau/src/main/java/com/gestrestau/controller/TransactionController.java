package com.gestrestau.controller;


import org.springframework.web.bind.annotation.RestController;

import com.gestrestau.model.Entities.Dish;
import com.gestrestau.model.Entities.Transaction;
import com.gestrestau.model.repositories.TransactionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionRepo transactionRepository;

 
    
    @PostMapping("/saveData")
    public void saveData(@RequestBody Transaction transaction) { 
        
        System.out.println(transaction);
        transactionRepository.save(transaction);
    }


    @GetMapping("/all")
    public Iterable<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    @GetMapping("/total-quantity/{ingredientId}")
    public int getTotalQuantityForIngredient(@PathVariable Long ingredientId) {
        return transactionRepository.getTotalQuantityForIngredient(ingredientId);
    }
   
    
}
