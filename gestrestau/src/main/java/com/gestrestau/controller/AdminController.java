package com.gestrestau.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import java.util.Iterator;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gestrestau.model.Entities.Dish;
import com.gestrestau.model.Entities.DishIngredient;
import com.gestrestau.model.Entities.Ingredient;
import com.gestrestau.model.Entities.Menu;
import com.gestrestau.model.Entities.Transaction;
import com.gestrestau.model.repositories.DishIngredientRepo;
import com.gestrestau.model.repositories.DishRepository;
import com.gestrestau.model.repositories.IngredientsRepo;
import com.gestrestau.model.repositories.MenuRepository;
import com.gestrestau.model.repositories.TransactionRepo;



@Controller
@RequestMapping("/admin") // RequestMapping in the methods (below), will be relative to /admin
public class AdminController {
    
    @Inject
    IngredientsRepo iRepo;

    @Inject
    TransactionRepo trRepo;

    @Inject
    DishIngredientRepo dishIngredientRepo;

    @Inject
    DishRepository dishRepo;

    @Inject
    MenuRepository menuRepo;

   
    @GetMapping("/welcome")
    public String ShowUserPage(Authentication auth, Model model){
        String email = ((UserDetails) auth.getPrincipal()).getUsername();
        if(email.isEmpty()){
            System.err.println("Vide");
        }
        else{
            model.addAttribute("email", email);
        }
        

        return "AdminTemplates/WelcomeAdmin";
    }

    /*Controller that shows the stock inside the database */
    @GetMapping("/Management/stock")
    public String ShowStocksPage(Authentication auth, Model model){
        Iterable<Ingredient> ingredientsIterator = iRepo.findAll();
        // Transformed Iterable to List to make it easier to check if list is empty or not
        List<Ingredient> ingredientsList = new ArrayList<>();
        ingredientsIterator.forEach(ingredientsList::add);
        List<Object[]> result = trRepo.calculateAvailableStock(ingredientsList);
        if(result.isEmpty()){
            boolean emptyList = true;
            model.addAttribute("EmptyList", emptyList);
        }
        else{
            model.addAttribute("TransactionList", result);
        }
        return "AdminTemplates/StockMgmt";
    }


    @GetMapping("/Management/users")
    public String ShowUsersMgmtPage(Authentication auth, Model model){
        String email = ((UserDetails) auth.getPrincipal()).getUsername();
        if(email.isEmpty()){
            System.err.println("Vide");
        }
        else{
            System.err.println(email);
        }
        model.addAttribute("email", email);

        return "AdminTemplates/WelcomeAdmin";
    }


    @GetMapping("/Management/menu")
    public String ShowMenuMgmtPage(Authentication auth, Model model){
        String email = ((UserDetails) auth.getPrincipal()).getUsername();
        if(email.isEmpty()){
            System.err.println("Vide");
        }
        else{
            System.err.println(email);
        }
        model.addAttribute("email", email);

        return "AdminTemplates/WelcomeAdmin";
    }

    @GetMapping("/Management/menu/AddIngredient")
    public String showAddIngredientPage(){
        return "AdminTemplates/AddIngredient";
    }

    @PostMapping("/Management/menu/AddIngredient")
    public String AddIngredientForm(@ModelAttribute("ingredient") Ingredient ing,@RequestParam("quantity") Integer quantity,Model model){
        iRepo.save(ing);
        Transaction transaction2 = new Transaction();
        transaction2.setIngredient(ing);
        transaction2.setAction(quantity);
        System.err.println(quantity);
        transaction2.setDate(new Date());
        trRepo.save(transaction2);
        return "AdminTemplates/AddIngredient";
    }


    /**
     * Controller that redirects to menu management
     * 
     */
    @GetMapping("/Management/editMenu")
    public String ManageMenu(Model model){
        model.addAttribute("dishList", getDishesList());
        return "AdminTemplates/MenuMgmt";
    }



    /**
     * Controller that validates a new menu
     * @param menuName
     * @param selectedDishes
     * @param model
     * @return
     */

    @PostMapping("Management/editMenu/submitMenu")
    public String SubmitMenu(@RequestParam(name = "menuName") String menuName, @RequestParam(name = "selectedDishes", required = false) List<Long> selectedDishes,Model model){

        Menu m = new Menu();
        // List of Dishes associated to the created menu "m"
        List<Dish> dishes = new ArrayList<>();
        
        if(selectedDishes != null ){
            for (int i = 0; i<selectedDishes.size();i++) {
                Dish d = dishRepo.findById(selectedDishes.get(i)).orElse(null);
                if (d != null) {
                    dishes.add(d);
                }
            }
            m.setDishs(dishes);
            m.setName(menuName);
            menuRepo.save(m);
        }
        else{
             model.addAttribute("dishList", getDishesList());
            model.addAttribute("errorMessage", "You Should select at least a dish !");
            return "AdminTemplates/MenuMgmt";
        }

        return "redirect:/admin/Management/editMenu";
    }
    
    @GetMapping("/Management/viewMenu")
    public String ViewMenus(Model model){
        model.addAttribute("menuList", getMenusList());
        return "AdminTemplates/ListOfMenus";
    }


    @GetMapping("Management/menus/{id}")
    public String viewMenuDetails(@PathVariable Long id, Model model) {
        Menu menu = menuRepo.findById(id).orElse(null);
        if(menu != null){
            List<Dish> dishList = menu.getDishs();
            model.addAttribute("menu", menu);
            model.addAttribute("dishList", dishList);
        }
        return "AdminTemplates/viewMenu";
}


    

    /**
     * Controller that redirects to user management
     * 
     */
    @GetMapping("/Management/UserManagement")
    public String ManageUsers(){
        return "AdminTemplates/UserMgmt";
    }

    /**
     * Method that returns the list of ingredients, to avoid code duplication
     * @return
     */
    private List<Ingredient> getIngredientsList() {
        Iterable<Ingredient> ingredientsIterator = iRepo.findAll();
        List<Ingredient> ingredientsList = new ArrayList<>();
        ingredientsIterator.forEach(ingredientsList::add);
        return ingredientsList;
    }

     /**
     * Method that returns the list of dishes, to avoid code duplication inside some functions
     * @return
     */
    private List<Dish> getDishesList() {
         Iterable<Dish> dishIterator = dishRepo.findAll();
        List<Dish> dishList = new ArrayList<>();
        dishIterator.forEach(dishList::add);
        return dishList;
    }

     /**
     * Method that returns the list of menus, to avoid code duplication inside some functions
     * @return
     */
    private List<Menu> getMenusList() {
         Iterable<Menu> MenuIterator = menuRepo.findAll();
        List<Menu> menuList = new ArrayList<>();
        MenuIterator.forEach(menuList::add);
        return menuList;
    }

    

    /**
     * Method that removes null objects from a list if it contains any
     * @param <T>
     * @param list
     */
    private <T> void removeNullElements(List<T> list) {
        Iterator<T> iterator = list.iterator();
        
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element == null) {
                iterator.remove();
            }
        }
    }

    /**
     * To check if all values inside a a list are null objects
     * @param quantities
     * @return
     */
    private boolean allQuantitiesNull(List<Integer> quantities) {
        return quantities.stream().allMatch(Objects::isNull);
    }


    @GetMapping("Management/editMenu/dishCreation")
    public String CreateDish(Model m){
        m.addAttribute("IngredientList", getIngredientsList());
        return "AdminTemplates/CreateDish";
    }
    

  
    @PostMapping("Management/editMenu/dishCreation/submitDish")
    public String SubmitDish(@RequestParam(name = "dishName") String dishName,@RequestParam(name = "dishPrice") float dishPrice,
                             @RequestParam(name = "selectedIngredients", required = false) List<Long> selectedIngredients,
                             @RequestParam(name = "quantities", required = false) List<Integer> quantities,
                             Model model){

        Dish d = new Dish(dishName, dishPrice);
        // List of Ingredients associated to the created dish "d"
        List<DishIngredient> dishIngredients = new ArrayList<>();
        
        if(selectedIngredients != null && quantities != null && !allQuantitiesNull(quantities)){
            removeNullElements(quantities);
            for (int i = 0; i<selectedIngredients.size();i++) {
                Ingredient ingredient = iRepo.findById(selectedIngredients.get(i)).orElse(null);
                Integer quantity = quantities.get(i);
                if (ingredient != null) {
                    DishIngredient dishIngredient = new DishIngredient();
                    dishIngredient.setDish(d);
                    dishIngredient.setIngredient(ingredient);
                    dishIngredient.setQuantite(quantity);

                    // Addoing the dishIngredient to the list of DishIngredients
                    dishIngredients.add(dishIngredient);
                    // Not saving the dishIngredient here to not get a transient error
                }
            }
            d.setDishIngredients(dishIngredients);
            dishRepo.save(d);
            for(DishIngredient dishIngredient : dishIngredients){
                // Saving the dishIngredient in the database
                dishIngredientRepo.save(dishIngredient);
            }
        }
        else{
            model.addAttribute("IngredientList", getIngredientsList());
            model.addAttribute("errorMessage", "You either didn't choose an ingredient or a quantity !");
            return "AdminTemplates/CreateDish";
        }

        return "redirect:/admin/Management/editMenu/dishCreation";
    }

    
}
