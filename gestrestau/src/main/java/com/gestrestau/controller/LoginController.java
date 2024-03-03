package com.gestrestau.controller;



//import java.security.Principal;

import javax.inject.Inject;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestrestau.model.repositories.UserRepo;
import com.gestrestau.model.user.User;
import com.gestrestau.model.user.UserRole;

@Controller
public class LoginController {

    @Inject
    UserRepo urep;
    
    @GetMapping("/login")
    public String ShowLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String loginTreatement(){
        return "redirect:/login/welcome";
    }

    @GetMapping("/login/welcome")
    
    public String ShowUserPage(Authentication auth, Model model){
        String email = ((UserDetails) auth.getPrincipal()).getUsername();
        model.addAttribute("email", email);
        Optional<User> u = urep.findByEmail(email);

        for (UserRole element : u.get().getRoles()) {
            if(element.getAuthority().equals("ROLE_ADMIN")){
                return "redirect:/admin/welcome";
            }
        }
            return "welcomeUser";
    }

}
