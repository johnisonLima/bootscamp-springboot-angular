package com.example.spring_security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to the home page!";
    }

    @GetMapping("/user")
    // @PreAuthorize("hasAnyRole('USER', 'ADMIN')") // @PreAuthorize: Bloqueia acessos dentro do controller.
    public String user() {
        return "Authenticated user!";
    }

    @GetMapping("/admin")
    // @PreAuthorize("hasRole('ADMIN')") // @PreAuthorize: Bloqueia acessos dentro do controller.
    public String admin() {
        return "Authenticated admin!";
    }

    
}
