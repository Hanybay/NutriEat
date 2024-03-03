package com.gestrestau.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.gestrestau.model.repositories.UserRepo;
import com.gestrestau.model.user.User;
import com.gestrestau.model.user.UserService;



@Controller
public class SignupController{
    
    @Inject
    UserRepo urepo;

    @Inject
    UserService userv;

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }
    

    @RequestMapping("/register")
    public String UserRegistrationTreatment(@ModelAttribute("user") User u, Model model){
        model.addAttribute("email", u.getEmail());
        model.addAttribute("pwd", u.getPassword());
        model.addAttribute("firstname", u.getUsername());
        model.addAttribute("lastname", u.getLastname());

        
        userv.saveHashedPassword(u, u.getPassword());       
        urepo.save(u);
        return "welcomeUser";
    }
}