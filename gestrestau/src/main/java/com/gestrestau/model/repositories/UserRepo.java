package com.gestrestau.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gestrestau.model.user.User;
import java.util.Optional;


public interface UserRepo extends CrudRepository<User,Long>{
    public Optional<User> findByEmail(String email); 
    
}