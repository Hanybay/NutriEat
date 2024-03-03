package com.gestrestau.model.user;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.gestrestau.model.repositories.UserRepo;

@Component
public class UserService implements UserDetailsService{
    
    @Inject
    UserRepo urep;

     public final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = urep.findByEmail(username);
        if (opt.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        User u = opt.get();
        return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), u.getRoles());
    }

    /*
     * Saves Hashed password set by the setHashedPassword method
     */
    public User saveHashedPassword(User u, String unHashedPassword){
        setHashedPassword(u, unHashedPassword);
        urep.save(u);
        return u;
    }

    public void setHashedPassword(User u, String unHashedPassword){
        String encryptedPassword = encoder.encode(unHashedPassword);
        u.setPassword(encryptedPassword);
    }


    public void makeUserAdmin(String username) {
        User u = urep.findByEmail(username).orElse(null);
        u.getRoles().add(UserRole.ADMIN);
        urep.save(u);
    }


}
