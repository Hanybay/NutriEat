package com.gestrestau;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gestrestau.model.repositories.UserRepo;
import com.gestrestau.model.user.UserService;

@Configuration
@EnableWebSecurity
public class Security {
    
    @Inject
    UserRepo urep;
    
    
    /*This method is called when the user inserts his details to log in 
     * It is called to compare the password to the hashed password in the database
    */
    @Bean
    public PasswordEncoder encoder(UserService userDetailsService) {
        return userDetailsService.encoder;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth-> auth 
        .requestMatchers(AntPathRequestMatcher.antMatcher("/"), AntPathRequestMatcher.antMatcher("/signup"), 
                         AntPathRequestMatcher.antMatcher("/login"),
                         AntPathRequestMatcher.antMatcher("/login/**"),
                         AntPathRequestMatcher.antMatcher("/**"),
                         AntPathRequestMatcher.antMatcher("/register"),
                         AntPathRequestMatcher.antMatcher("/api/**")
                         ).permitAll()


        /*Console H2c */
        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2c/**")).permitAll()//.hasRole("ADMIN")
        .requestMatchers(AntPathRequestMatcher.antMatcher("/SETUP/**"), AntPathRequestMatcher.antMatcher("/public"), AntPathRequestMatcher.antMatcher("/public/**")).permitAll()        
        
        /*ADMIN */
        .requestMatchers(AntPathRequestMatcher.antMatcher("/admin/**")).hasRole("ADMIN")
        )
        .csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2c/**")))
        .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
        .formLogin(form -> form.loginPage("/login")
        .failureUrl("/login?error=true")
        .defaultSuccessUrl("/login/welcome", true))
        .csrf(csrf -> csrf.disable())// Désactiver la protection CSRF
        
        
        

        .httpBasic(Customizer.withDefaults());
        return http.build();
    }   
}
