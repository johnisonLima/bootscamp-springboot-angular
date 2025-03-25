package com.example.api_rest.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.api_rest.dominan.model.User;
import com.example.api_rest.dominan.repository.UserRepository;
import com.example.api_rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (user.getName() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("Name and email are required");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User already exists");
        }
        return userRepository.save(user);
    }
    
}
