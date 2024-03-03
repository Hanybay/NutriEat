package com.gestrestau.controller;
import javax.inject.Inject;
import com.gestrestau.model.user.User;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestrestau.model.repositories.UserRepo;

@Controller
public class VisitorController{

    @Inject
    UserRepo urepo;

    @RequestMapping("/sendvisitor")
    public String guest(){
        return "guestpage";
    }

    @PostMapping("/visitor")
    public String UserVisitTreatment(@ModelAttribute("user") User u, Model model,HttpSession session){
        // model.addAttribute("firstname", u.getUsername());
        // model.addAttribute("lastname", u.getLastname());
        session.setAttribute("firstname", u.getUsername());
        session.setAttribute("lastname", u.getLastname());

        
        return "welcomeGuest";
    }

    @GetMapping("/visitor")
    public String UserVisit(HttpSession session, Model model){
        String firstName = (String) session.getAttribute("firstname");
        String lastName = (String) session.getAttribute("lastname");
    
        model.addAttribute("firstname", firstName);
        model.addAttribute("lastname", lastName);
    
        return "welcomeGuest";
    }

}
