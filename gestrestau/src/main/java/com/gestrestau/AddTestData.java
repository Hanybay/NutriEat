package com.gestrestau;

import java.util.ArrayList;
import java.util.Date;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
//import java.util.Random;

import javax.inject.Inject;

import com.gestrestau.model.Entities.Ingredient;
import com.gestrestau.model.Entities.Transaction;
import com.gestrestau.model.repositories.IngredientsRepo;
import com.gestrestau.model.repositories.TransactionRepo;
import com.gestrestau.model.repositories.UserRepo;
import com.gestrestau.model.user.User;
import com.gestrestau.model.user.UserService;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 * AddTestData
 */
/* ___GENERATETESTDATA___ */
@Service
public class AddTestData {

    @Inject
    UserService userService; // This will be set automatically (injection) by spring data, with an implementation of UserService
    @Inject
    UserRepo userRepo;
    @Inject
    IngredientsRepo ingRepo;
    @Inject
    TransactionRepo trRepo;
    
    interface RandomElement {
         <T> T gen(List<T> l);
    }

    public void generateTestData() {
        /* ___GENERATETESTDATA___ */
        /*Adding admin Hany */
        User admin = new User("hany");
        userService.saveHashedPassword(admin, "hany");
        userService.makeUserAdmin("hany");
        /*Adding admin Amin */
        User adminA = new User("amin");
        userService.saveHashedPassword(adminA, "amin");
        userService.makeUserAdmin("amin");
        /*Adding admin admin (for eveyone) */
        User adminG = new User("admin");
        userService.saveHashedPassword(adminG, "admin");
        userService.makeUserAdmin("admin");

        // List<Ingredient> ingList = new ArrayList<>();
        // int k=1;
        // for(int i = 1; i<=40; i++){
        //     ingList.add(ingRepo.save(new Ingredient("Ing "+Integer.toString(k),"Veg "+Integer.toString(k),k,"g")));
        //     k+=1;
        // }
        // List<Transaction> trList = new ArrayList<>();
        // for (int i = 1; i <= 40; i++) {
        //     Ingredient ingredient = ingList.get(i - 1); 

        //     Transaction transaction1 = new Transaction();
        //     Random random = new Random();
        //     int randomAction1 = random.nextInt(21) - 10;
        //     transaction1.setIngredient(ingredient);
        //     transaction1.setAction(randomAction1);
        //     transaction1.setDate(new Date());
        //     trList.add(trRepo.save(transaction1));

        //      Transaction transaction2 = new Transaction();
        //      int randomAction2 = random.nextInt(21) - 10;
        //      transaction2.setIngredient(ingredient);
        //      transaction2.setAction(randomAction2);
        //      transaction2.setDate(new Date());
        //      trList.add(trRepo.save(transaction2));
        // }
    }

}
