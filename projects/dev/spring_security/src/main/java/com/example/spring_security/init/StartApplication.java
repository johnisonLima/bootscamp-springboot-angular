package com.example.spring_security.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_security.model.User;
import com.example.spring_security.repository.UserRepository;

public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin") == null) {
            User admin = new User();
            admin.setName("Admin");
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder().encode("admin"));
            admin.getRoles().add("ADMIN");
            userRepository.save(admin);
        }

        if (userRepository.findByUsername("user") == null) {
            User user = new User();
            user.setName("User");
            user.setUsername("user");
            user.setPassword(passwordEncoder().encode("user"));
            user.getRoles().add("USER");
            userRepository.save(user);
        }
    }

    public PasswordEncoder passwordEncoder()  {
        return new BCryptPasswordEncoder();
    }

}
