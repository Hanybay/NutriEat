package com.gestrestau.model.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "allusers")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUser;
    
    String username;
    
    String lastname;
    
    String email;
    
    String password;

    /*
     * Collection of elements that contains the roles that a user can have. 
    */
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    private Set<UserRole> roles = new HashSet<>();


    public User(){

    }

    public User(String email){
        this.email = email;
    }

    /*Constructor used in case a client is only a visitor and doesn't want to be a member */
    public User(String name, String lastname){
        this.username = name;
        this.lastname = lastname;
    }

    public User(String email, String password, List<String> roles){
        this.email = email;
        this.password = password;
        this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
    }

    /*Constructor used in case a client wants to become a member */
    public User(String name, String lastname, String email, String password, List<String> roles){
        this.username = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
    }

}
